package com.example.newvitameanshospital.customview

import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.Interpolator
import androidx.core.widget.NestedScrollView
import com.example.newvitameanshospital.R

class BounceScrollView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    NestedScrollView(context, attrs, defStyleAttr) {
    var isScrollHorizontally: Boolean
    private var mDamping: Float
    var isIncrementalDamping: Boolean
    private var mBounceDelay: Long
    private var mTriggerOverScrollThreshold: Int
    var isDisableBounce: Boolean
    private var mInterpolator: Interpolator
    private var mChildView: View? = null
    private var mStart = 0f
    private var mPreDelta = 0
    private var mOverScrolledDistance = 0
    private var mAnimator: ObjectAnimator? = null
    private var mScrollListener: OnScrollListener? = null
    private var mOverScrollListener: OnOverScrollListener? = null

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {}

    override fun canScrollVertically(direction: Int): Boolean {
        return !isScrollHorizontally
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return isScrollHorizontally
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (mChildView == null && childCount > 0 || mChildView !== getChildAt(0)) {
            mChildView = getChildAt(0)
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (mChildView == null || isDisableBounce) return super.onTouchEvent(ev)
        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> mStart = if (isScrollHorizontally) ev.x else ev.y
            MotionEvent.ACTION_MOVE -> {
                val delta: Float
                val now: Float = if (isScrollHorizontally) ev.x else ev.y
                delta = mStart - now
                val dampingDelta: Int = (delta / calculateDamping()).toInt()
                mStart = now
                var onePointerTouch = true
                if (mPreDelta <= 0 && dampingDelta > 0) {
                    onePointerTouch = false
                } else if (mPreDelta >= 0 && dampingDelta < 0) {
                    onePointerTouch = false
                }
                mPreDelta = dampingDelta
                if (onePointerTouch && canMove(dampingDelta)) {
                    mOverScrolledDistance += dampingDelta
                    if (isScrollHorizontally) {
                        mChildView!!.setTranslationX((-mOverScrolledDistance).toFloat())
                    } else {
                        mChildView!!.setTranslationY((-mOverScrolledDistance).toFloat())
                    }
                    if (mOverScrollListener != null) {
                        mOverScrollListener!!.onOverScrolling(
                            mOverScrolledDistance <= 0,
                            Math.abs(mOverScrolledDistance)
                        )
                    }
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mPreDelta = 0
                mOverScrolledDistance = 0
                cancelAnimator()
                if (isScrollHorizontally) {
                    mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_X, 0f)
                } else {
                    mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_Y, 0f)
                }
                mAnimator!!.setDuration(mBounceDelay).interpolator = mInterpolator
                if (mOverScrollListener != null) {
                    mAnimator!!.addUpdateListener { animation ->
                        val value = animation.animatedValue as Float
                        mOverScrollListener!!.onOverScrolling(
                            value <= 0,
                            Math.abs(value.toInt())
                        )
                    }
                }
                mAnimator!!.start()
            }
        }
        return super.onTouchEvent(ev)
    }

    private fun calculateDamping(): Float {
        var ratio: Float
        ratio = if (isScrollHorizontally) {
            Math.abs(mChildView!!.getTranslationX()) * 1.0f / mChildView!!.getMeasuredWidth()
        } else {
            Math.abs(mChildView!!.getTranslationY()) * 1.0f / mChildView!!.getMeasuredHeight()
        }
        ratio += 0.2f
        return if (isIncrementalDamping) {
            mDamping / (1.0f - Math.pow(ratio.toDouble(), 2.0).toFloat())
        } else {
            mDamping
        }
    }

    private fun canMove(delta: Int): Boolean {
        return if (delta < 0) canMoveFromStart() else canMoveFromEnd()
    }

    private fun canMoveFromStart(): Boolean {
        return if (isScrollHorizontally) scrollX == 0 else scrollY == 0
    }

    private fun canMoveFromEnd(): Boolean {
        return if (isScrollHorizontally) {
            var offset: Int = mChildView!!.getMeasuredWidth() - width
            offset = if (offset < 0) 0 else offset
            scrollX == offset
        } else {
            var offset: Int = mChildView!!.getMeasuredHeight() - height
            offset = if (offset < 0) 0 else offset
            scrollY == offset
        }
    }

    private fun cancelAnimator() {
        if (mAnimator != null && mAnimator!!.isRunning) {
            mAnimator!!.cancel()
        }
    }

    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(scrollX, scrollY, oldl, oldt)
        if (mScrollListener != null) {
            mScrollListener!!.onScrolling(scrollX, scrollY)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelAnimator()
    }

    var damping: Float
        get() = mDamping
        set(damping) {
            if (mDamping > 0) {
                mDamping = damping
            }
        }
    var bounceDelay: Long
        get() = mBounceDelay
        set(bounceDelay) {
            if (bounceDelay >= 0) {
                mBounceDelay = bounceDelay
            }
        }

    fun setBounceInterpolator(interpolator: Interpolator) {
        mInterpolator = interpolator
    }

    var triggerOverScrollThreshold: Int
        get() = mTriggerOverScrollThreshold
        set(threshold) {
            if (threshold >= 0) {
                mTriggerOverScrollThreshold = threshold
            }
        }

    fun setOnScrollListener(scrollListener: OnScrollListener?) {
        mScrollListener = scrollListener
    }

    fun setOnOverScrollListener(overScrollListener: OnOverScrollListener?) {
        mOverScrollListener = overScrollListener
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////
    private class DefaultQuartOutInterpolator : Interpolator {
        override fun getInterpolation(input: Float): Float {
            return (1.0f - Math.pow((1 - input).toDouble(), 4.0)).toFloat()
        }
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////
    interface OnScrollListener {
        fun onScrolling(scrollX: Int, scrollY: Int)
    }

    // //////////////////////////////////////////////////////////////////////////////////////////////
    interface OnOverScrollListener {
        /**
         * @param fromStart LTR, the left is start; RTL, the right is start.
         */
        fun onOverScrolling(fromStart: Boolean, overScrolledDistance: Int)
    }

    companion object {
        private const val DEFAULT_DAMPING_COEFFICIENT = 4.0f
        private const val DEFAULT_SCROLL_THRESHOLD = 20
        private const val DEFAULT_BOUNCE_DELAY: Long = 400
    }

    init {
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false
        isFillViewport = true
        overScrollMode = View.OVER_SCROLL_NEVER
        val a: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.BounceScrollView, 0, 0)
        mDamping = a.getFloat(R.styleable.BounceScrollView_damping, DEFAULT_DAMPING_COEFFICIENT)
        val orientation = a.getInt(R.styleable.BounceScrollView_scrollOrientation, 0)
        isScrollHorizontally = orientation == 1
        isIncrementalDamping = a.getBoolean(R.styleable.BounceScrollView_incrementalDamping, true)
        mBounceDelay = a.getInt(
            R.styleable.BounceScrollView_bounceDelay,
            DEFAULT_BOUNCE_DELAY.toInt()
        ).toLong()
        mTriggerOverScrollThreshold = a.getInt(
            R.styleable.BounceScrollView_triggerOverScrollThreshold,
            DEFAULT_SCROLL_THRESHOLD
        )
        isDisableBounce = a.getBoolean(R.styleable.BounceScrollView_disableBounce, false)
        val enable = a.getBoolean(R.styleable.BounceScrollView_nestedScrollingEnabled, true)
        a.recycle()
        isNestedScrollingEnabled = enable
        mInterpolator = DefaultQuartOutInterpolator()
    }
}
