# circuit-breaker

1. **Circuit Breaker Yap?land?rmas?:**
    - **`resilience4j.circuitbreaker`:** Resilience4j Circuit Breaker i?in ana yap?land?rma blo?u.
    - **`instances`:** Farkl? Circuit Breaker ?rnekleri i?in yap?land?rma ayarlar?.
    - **`orderProcess`:** `orderProcess` ad? verilen Circuit Breaker ?rne?i i?in ayarlar.
        - **`registerHealthIndicator: true`:** Circuit Breaker i?in sa?l?k g?stergesini etkinle?tirir.
        - **`slidingWindowSize: 10`:** Circuit Breaker'?n hata oran?n? de?erlendirmek i?in kulland??? ?a?r?lar?n kayar pencere boyutunu belirtir.
        - **`permittedNumberOfCallsInHalfOpenState: 5`:** Yar? a??k durumda izin verilen ?a?r? say?s?n? belirtir.
        - **`minimumNumberOfCalls: 5`:** Circuit Breaker'?n ?al??mas? i?in gereken minimum ?a?r? say?s?n? belirtir.
        - **`waitDurationInOpenState: 5s`:** Devre a??k durumda bekleme s?resini belirtir.
        - **`failureRateThreshold: 50`:** Hata oran? e?i?ini belirtir; bu oran a??ld???nda devre a??l?r.
