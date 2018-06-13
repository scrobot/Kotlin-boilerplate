package com.github.scrobot.kotlin_boilerplate.global

sealed class BottombarMenuItem

object Person: BottombarMenuItem()
object Location: BottombarMenuItem()
object Episode: BottombarMenuItem()


sealed class ValidationStatus
class ValidationInit: ValidationStatus()
class ValidationFailed: ValidationStatus()
class ValidationSuccess: ValidationStatus()