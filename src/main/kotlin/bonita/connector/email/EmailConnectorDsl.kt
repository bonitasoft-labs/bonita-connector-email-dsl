package bonita.connector.email

import org.bonitasoft.engine.dsl.process.ExpressionDSLBuilder
import org.bonitasoft.engine.dsl.process.ProcessDSLMarker
import org.bonitasoft.engine.dsl.process.connectors.ConnectorImplDsl


/**
 * Sends an email
 */
fun org.bonitasoft.engine.dsl.process.ConnectorBuilder.email(init: EmailConnectorDsl.() -> Unit) {
    EmailConnectorDsl(this).apply(init)
}
@ProcessDSLMarker
class EmailConnectorDsl (connectorBuilder: org.bonitasoft.engine.dsl.process.ConnectorBuilder) : ConnectorImplDsl(connectorBuilder, "email.impl") {

    /**
     * Host of the smtp server
     */
    fun smtpHost(expression: ExpressionDSLBuilder) = connectorBuilder.input("smtpHost", expression)

    /**
     * Port of the smtp server
     */
    fun smtpPort(expression: ExpressionDSLBuilder) = connectorBuilder.input("smtpPort", expression)

    /**
     * Dender's email
     */
    fun from(expression: ExpressionDSLBuilder) = connectorBuilder.input("from", expression)


    /**
     * Receiver's email
     */
    fun to(expression: ExpressionDSLBuilder) = connectorBuilder.input("to", expression)


    /**
     * Subject of the email
     */
    fun subject(expression: ExpressionDSLBuilder) = connectorBuilder.input("subject", expression)

    /**
     * Content of the email
     */
    fun message(expression: ExpressionDSLBuilder) = connectorBuilder.input("message", expression)

}