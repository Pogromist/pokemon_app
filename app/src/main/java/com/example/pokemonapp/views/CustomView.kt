package com.example.pokemonapp.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.pokemonapp.App
import com.example.pokemonapp.R
import com.example.pokemonapp.navigation.Screens
import com.example.pokemonapp.repository.Position
import com.example.pokemonapp.utils.Constants.Companion.SQUARE_SIZE_DEF

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it, R.styleable.CustomView,
                0, 0
            )
            val squareColor = typedArray.getColor(R.styleable.CustomView_square_color, Color.BLUE)
            val squareSize = typedArray.getDimensionPixelSize(
                R.styleable.CustomView_square_size,
                SQUARE_SIZE_DEF
            )
            typedArray.recycle()
        }
    }

    fun drawShape() {
        App.INSTANCE.router.replaceScreen(Screens.CustomViewScreen())
    }

    override fun onDraw(canvas: Canvas?) {
        if (Position.flag == true) {
            drawCircle(canvas)
            Position.flag = false
        } else {
            drawRectangle(canvas)
            Position.flag = true
        }
    }

    private fun drawCircle(canvas: Canvas?) {
        canvas?.drawCircle(500f, 500f, 200f, paint)
    }

    private fun drawRectangle(canvas: Canvas?) {
        canvas?.drawRect(500f, 500f, 100f, 100f, paint)
    }
}