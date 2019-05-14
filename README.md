# Bonita email connector with Kotlin DSL extension

This project allows to add the email connectors using an extension of the Koltin DSL

to add the email connector simply add a dependency on `org.bonitasoft.connectors:bonita-connector-email-dsl:1.1.0`

then the connector can be added into your processes like below

```kotlin
automaticTask("Notify reject") {
            connector {
                email {
                    smtpHost(parameter("smtpHost"))
                    smtpPort(constant(2525))
                    from(constant("no-reply@acme.com"))
                    to(groovy("""
                                |def userId = apiAccessor.getProcessAPI().getProcessInstance(processInstanceId).getStartedBy()
                                |return apiAccessor.getIdentityAPI().getUserWithProfessionalDetails(userId).contactData.email
                            """.trimMargin()) {
                        dependency(ExpressionDSLBuilder().apply { engineConstant(ExpressionConstants.PROCESS_INSTANCE_ID) })
                        dependency(ExpressionDSLBuilder().apply { engineConstant(ExpressionConstants.API_ACCESSOR) })
                    })
                    subject(constant("Your loan was rejected"))
                    message(stringSubstitution("""
                        |
                        | We are sorry to inform you that your Loan was rejected because:
                        | ${'$'}{reason}
                        |
                        | Thank you
                        |
                    """.trimMargin()) {
                        dataRef("reason")
                    })
                    sslSupport(constant(false))
                }
            }
        }
```