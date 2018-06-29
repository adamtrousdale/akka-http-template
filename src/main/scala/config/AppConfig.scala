package config

import com.typesafe.config.{ Config, ConfigFactory }

trait AppConfig {

  val config: Config = ConfigFactory.load()

}
