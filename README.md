# BCH Software Inc. - Sprint 2: Apex Security Turnstile (Android (Kotlin + Compose))

Client: Apex Entertainment - "The Vortex" coaster.
Your role packet tells you exactly what to do on Day 1. Start there.

## Who owns which file
| File | Owner |
|---|---|
| `app/src/main/java/com/example/turnstile/GateRules.kt` | SE (Story 1) |
| `app/src/main/java/com/example/turnstile/TurnstileGate.kt` | SE (Story 2) |
| `app/src/main/java/com/example/turnstile/MainActivity.kt` | SE (Story 2) |
| `app/src/test/java/com/example/turnstile/QaBoundaryTest.kt` | QA (Story 3) |
| `app/src/test/java/com/example/turnstile/CcaSecurityTest.kt` | CCA (Story 4) |
| `app/src/main/java/com/example/turnstile/AiSuggestedGate.kt` | Nobody - AI-suggested code for the CCA to audit. DO NOT use it in the app. |
| `ISSUES.md` | PM - copy into GitHub issues |

Only edit the files you own. If you need a change in someone else's file, open an issue.

## Running the tests (JUnit 4 local unit tests (already in every new Android Studio project - same as the Tip Time testing codelab))
- Everything: Right-click the com.example.turnstile (test) folder > Run 'Tests in com.example.turnstile'
- QA only: Open QaBoundaryTest.kt > click the green arrow next to 'class QaBoundaryTest' > Run
- CCA only: Open CcaSecurityTest.kt > click the green arrow next to 'class CcaSecurityTest' > Run

The Run panel shows a tree: green check = passed, red/orange X = failed (click it to see Expected vs Actual), grey circle = ignored. No emulator needed for these tests.

## Running the app
Run > Run 'app' on the emulator
