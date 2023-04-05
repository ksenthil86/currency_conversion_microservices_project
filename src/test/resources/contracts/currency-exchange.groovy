import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    description("Validate returning currency exchange for from and to")
    name("should_return_exchange")
    request {
        method(GET())
        url("/currency-exchange/from/AUD/to/INR")
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status(200)
        headers {
            contentType(applicationJson())
        }
        body('''
        {
          "id":1004,
          "currency_from":"AUD" ,
          "currency_to":"INR",
          "conversion_multiple": 50.5
        }
        ''')
    }
}