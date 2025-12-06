import RabbitMQHandler from './RabbitMQHandler.js'
import CronHandler from './CronHandler.js'
import JDBCHandler from './JDBCHandler.js'

export default {
  rabbitmq: RabbitMQHandler,
  cron: CronHandler,
  jdbc: JDBCHandler
}