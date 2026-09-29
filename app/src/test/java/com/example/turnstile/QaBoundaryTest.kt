package com.example.turnstile

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

/*
 * QA - Boundary Test Suite (Sprint 2, Story 3)
 * Run: click the green arrow next to the class name.
 * Each test = one row of your QA Test Matrix.
 * HOW TO FINISH A TODO TEST: Delete the @Ignore("TODO") line, then write ONE assertEquals line copying the pattern from the examples.
 */
class QaBoundaryTest {

    // ---------- Height boundary (48 inches) ----------

    @Test
    fun q1_patronExactly48InchesAge13IsGranted() {
        assertEquals("GRANTED", GateRules.checkEntry("PATRON", 48.0, 13, false))
    }

    @Test
    fun q2_patron47point9InchesIsTooShort() {
        assertEquals("DENIED_TOO_SHORT", GateRules.checkEntry("PATRON", 47.9, 30, false))
    }

    @Ignore("TODO")
    @Test
    fun q3_patron48point1InchesIsGranted() {
        // TODO (Q3): ticket "PATRON", height 48.1, age 30, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    // ---------- Age boundary (13) ----------

    @Ignore("TODO")
    @Test
    fun q4_age12WithoutGuardianNeedsGuardian() {
        // TODO (Q4): ticket "PATRON", height 60.0, age 12, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    @Ignore("TODO")
    @Test
    fun q5_age12WithGuardianIsGranted() {
        // TODO (Q5): ticket "PATRON", height 60.0, age 12, guardian true  ->  expect ??? (look it up in the Rules table)
    }

    @Ignore("TODO")
    @Test
    fun q6_age13WithoutGuardianIsGranted() {
        // TODO (Q6): ticket "PATRON", height 60.0, age 13, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    // ---------- Ticket types ----------

    @Ignore("TODO")
    @Test
    fun q7_vipNormalRiderGetsVipLane() {
        // TODO (Q7): ticket "VIP", height 60.0, age 30, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    @Ignore("TODO")
    @Test
    fun q8_unauthorizedIsDenied() {
        // TODO (Q8): ticket "UNAUTHORIZED", height 60.0, age 30, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    @Ignore("TODO")
    @Test
    fun q9_topOfValidRangeIsGranted() {
        // TODO (Q9): ticket "PATRON", height 96.0, age 120, guardian false  ->  expect ??? (look it up in the Rules table)
    }

    @Ignore("TODO")
    @Test
    fun q10_vipChildWithGuardianGetsVipLane() {
        // TODO (Q10): ticket "VIP", height 60.0, age 12, guardian true  ->  expect ??? (look it up in the Rules table)
    }

    // ---------- Analytics counters (runs once SE finishes Story 2) ----------

    @Ignore("TODO")
    @Test
    fun q11_newGateStartsAtZero() {
        val gate = TurnstileGate()
        // TODO (Q11): assert gate.grantedCount, gate.deniedCount and gate.totalScans are all 0
    }

    @Ignore("TODO")
    @Test
    fun q12_countersAfterTwoGrantsAndOneDeny() {
        val gate = TurnstileGate()
        gate.scan("PATRON", 60.0, 30, false)   // granted
        gate.scan("VIP", 60.0, 30, false)      // granted
        gate.scan("PATRON", 40.0, 30, false)   // denied
        // TODO (Q12): assert granted is 2, denied is 1, total is 3
    }

}
