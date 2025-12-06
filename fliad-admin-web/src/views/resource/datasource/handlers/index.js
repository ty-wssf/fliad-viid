import RabbitMQHandler from './RabbitMQHandler.js'
import CronHandler from './CronHandler.js'
import JDBCHandler from './JDBCHandler.js'
import HttpHandler from './HttpHandler.js'

export default {
  rabbitmq: RabbitMQHandler,
  cron: CronHandler,
  jdbc: JDBCHandler,
  http: HttpHandler
}