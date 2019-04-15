package bonita.connector.email

import org.bonitasoft.engine.dsl.process.ExpressionDSLBuilder
import org.bonitasoft.engine.dsl.process.ProcessDSLMarker
import org.bonitasoft.engine.dsl.process.connectors.ConnectorImplDsl


fun org.bonitasoft.engine.dsl.process.ConnectorBuilder.email(init: EmailConnectorDsl.() -> Unit) {
    EmailConnectorDsl(this).apply(init)
}
@ProcessDSLMarker
class EmailConnectorDsl (connectorBuilder: org.bonitasoft.engine.dsl.process.ConnectorBuilder) : ConnectorImplDsl(connectorBuilder, "email.impl") {

    /**
     * host of the smtp server
     */
    fun smtpHost(expression: ExpressionDSLBuilder) = connectorBuilder.input("smtpHost", expression)

    /**
     * port of the smtp server
     */
    fun smtpPort(expression: ExpressionDSLBuilder) = connectorBuilder.input("smtpPort", expression)
    fun from(expression: ExpressionDSLBuilder) = connectorBuilder.input("from", expression)
    fun to(expression: ExpressionDSLBuilder) = connectorBuilder.input("to", expression)
    fun subject(expression: ExpressionDSLBuilder) = connectorBuilder.input("subject", expression)
    fun message(expression: ExpressionDSLBuilder) = connectorBuilder.input("message", expression)

}