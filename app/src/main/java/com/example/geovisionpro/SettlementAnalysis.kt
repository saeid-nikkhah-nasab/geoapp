
package com.example.geovisionpro

object SettlementAnalysis {
    fun calculateElasticSettlement(q: Double, B: Double, modulus: Double, poisson: Double): Double {
        return (q * B * (1 - poisson * poisson)) / modulus
    }

    fun calculateConsolidationSettlement(coefficient: Double, layerThickness: Double, time: Double): Double {
        return coefficient * layerThickness * layerThickness / (2 * time)
    }
}
