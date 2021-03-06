package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PaymentControllerV1Test extends Simulation {

  private val httpConf = http.baseUrl(Configuration.baseUrl)
    .acceptHeader("application/json")

  private val sc = scenario("ControllerSimulationV1")
    .exec(http("request1")
      .put("/api/payment/v1"))

  setUp(
    sc.inject(atOnceUsers(10000))
  ).protocols(httpConf)
}
