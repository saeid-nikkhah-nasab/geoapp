
package com.example.geovisionpro

object BearingCapacity {
    fun calculateSquareFooting(load: Double, width: Double, depth: Double): Double {
        val cohesion = 25.0
        val unitWeight = 18.0
        val Nc = 5.14
        val Nq = 1.0
        val Nγ = 0.0
        return cohesion * Nc + (depth * unitWeight) * Nq + 0.5 * unitWeight * width * Nγ
    }

    fun calculateRectangularFooting(load: Double, width: Double, length: Double): Double {
        val cohesion = 25.0
        val unitWeight = 18.0
        val Nc = 5.14
        val Nq = 1.0
        val Nγ = 0.3
        return cohesion * Nc + (width * unitWeight) * Nq + 0.5 * unitWeight * (width + length) * Nγ
    }

    fun calculateCircularFooting(load: Double, radius: Double): Double {
        val cohesion = 25.0
        val unitWeight = 18.0
        val Nc = 5.14
        val Nq = 1.0
        val Nγ = 0.2
        return cohesion * Nc + (radius * unitWeight) * Nq + 0.5 * unitWeight * Math.PI * radius * radius * Nγ
    }

    fun calculateStripFooting(load: Double, width: Double): Double {
        val cohesion = 25.0
        val unitWeight = 18.0
        val Nc = 5.14
        val Nq = 1.0
        val Nγ = 0.25
        return cohesion * Nc + (width * unitWeight) * Nq + 0.5 * unitWeight * width * Nγ
    }
}
