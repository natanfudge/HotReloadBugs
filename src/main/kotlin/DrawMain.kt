//fun DrawContext.drawMain() {
//        Test.drawLine(this@drawMain)
//}


//object Test {
//    fun drawLine(context: DrawContext) {
//        for (i in 0 until 100) {
//            for (j in 0 until 100) {
//                if (j % 5 == 0) {
//                    //TODO: I think i will need to flip the Y value to match the book
//                    context.setPixel(i, j)
//                }
//            }
//        }
//    }
//}





object DDA : LineDrawingAlgorithm {
    override fun DrawContext.drawLine(line: Line) {
        for (i in 0 until 100) {
            for (j in 0 until 100) {
                if (j % 10 == 0) {
                    //TODO: I think i will need to flip the Y value to match the book
                    setPixel(i, j)
                }
            }
        }
    }

}

interface LineDrawingAlgorithm {
    fun DrawContext.drawLine(line: Line)
}


data class Point(val x: Int, val y: Int)
data class Line(val start: Point, val end: Point) {
    constructor(startX: Int, startY: Int, endX: Int, endY: Int) : this(Point(startX, startY), Point(endX, endY))

    val startX = start.x
    val startY = start.y
    val endX = end.x
    val endY = end.y
}