
class HitboxChecker(){
    fun isHit(line : Line, box : Box): Boolean {
        /*
        Create lines from the 4 sides of the box.
        If the line intersects any of these lines, then the line passes through the box.
         */
        //TOP
        if(doLinesIntersect(line, Line(box.x, box.y+box.height, box.x+box.width, box.y+box.height))){
            return true
        }

        //BOTTOM
        if(doLinesIntersect(line, Line(box.x, box.y, box.x+box.width, box.y))){
            return true
        }

        //LEFT
        if(doLinesIntersect(line, Line(box.x, box.y, box.x, box.y+box.height))){
            return true
        }

        //RIGHT
        if(doLinesIntersect(line, Line(box.x+box.width, box.y, box.x+box.width, box.y+box.height))){
            return true
        }

        return false
    }

    private fun getMathLine(l : Line) : MathLine {
        val m = (l.y2-l.y1)/(l.x2-l.x1);
        val b = -(m*l.x1)+l.y1

        return MathLine(m, b);
    }

    private fun isLineUndefined(l : Line) : Boolean {
        return l.x2-l.x1 == 0;
    }

    private fun doLinesIntersect(l1: Line, l2 : Line) : Boolean {
        //If we have any of the lines are undefined, check to see if they intersect
        if(isLineUndefined(l1)){
            if(isLineUndefined(l2)){
                //Parallel lines, won't intersect
                return false
            }

            val definedLine = l2;
            val undefinedLine = l1

            val ml =  getMathLine(definedLine)
            val y = (ml.m * undefinedLine.x1) + ml.b
            return y >= undefinedLine.y1 && y <= undefinedLine.y2
        } else if(isLineUndefined(l2)){
            if(isLineUndefined(l2)){
                //Parallel lines, won't intersect
                return false
            }

            val definedLine = l1;
            val undefinedLine = l2;

            val ml =  getMathLine(definedLine)
            val y = (ml.m * undefinedLine.x1) + ml.b
            return y >= undefinedLine.y1 && y <= undefinedLine.y2
        }

        val ml1 = getMathLine(l1);
        val ml2 = getMathLine(l2);

        //Check if lines are parallel, as they will never intersect if they are.
        if(ml1.m-ml2.m == 0){
            return false;
        }
        val x = (ml2.b- ml1.b)/(ml1.m-ml2.m);
        val y1 = ml1.m * (x) + ml1.b;
        val y2 = ml2.m * (x) + ml2.b;

        //Check that y values are equal and within range of original lines

        if(y1 < l1.y1 || y1 > l1.y2 || x < l1.x1 || x > l1.x2){
            return false
        }

        if(y2 < l2.y1 || y2 > l2.y2 || x < l2.x1 || x > l2.x2){
            return false
        }

        if(y1 != y2){
            return false
        }

        return true;
    }

    class Line constructor(val x1: Int, val y1: Int, val x2: Int, val y2: Int);

    class MathLine constructor(val m : Int, val b : Int){
        val undefinedSlope : Boolean = false
    }

    class Box constructor(val x: Int, val y: Int, val width : Int, val height : Int);
}

fun main(args: Array<String>){
    val line = HitboxChecker.Line((readLine() ?: "0").toInt(), (readLine() ?: "0").toInt(), (readLine() ?: "0").toInt(), (readLine() ?: "0").toInt())
    val box = HitboxChecker.Box((readLine() ?: "0").toInt(), (readLine() ?: "0").toInt(), (readLine() ?: "0").toInt(), (readLine() ?: "0").toInt())
    val hitCheck = HitboxChecker();

    if(hitCheck.isHit(line, box)){
        print(1);
    } else {
        print(0);
    }
}
