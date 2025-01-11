package api.ecommerce.br.apiecommerce.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.br.apiecommerce.config.auth.AwsSecretManager;

@RestController
@RequestMapping("/api/mercadopago")
public class MercadoPagoController {

    @PostMapping
    public ResponseEntity<List<Object>> sendBoletoPayment() {

        AwsSecretManager awsSecretManager = new AwsSecretManager();

        String jsonBody = """
                {
                    "transaction_amount": 225.34,
                    "date_of_expiration": "2025-01-15T19:30:00.000-03:00",
                    "sponsor_id": null,
                    "application_fee": null,
                    "payment_method_id": "bolbradesco",
                    "external_reference": "1724857151",
                    "metadata": {
                        "order_number": "order_1724857151"
                    },
                    "description": "PEDIDO NOVO - VIDEOGAME",
                    "payer": {
                        "first_name": "Joao",
                        "last_name": "Silva",
                        "email": "c.souzaf@hotmail.com",
                        "identification": {
                            "type": "CPF",
                            "number": "06128889590"
                        },
                        "address": {
                            "zip_code": "06233-200",
                            "street_name": "Av. das Nações Unidas",
                            "street_number": "3003",
                            "neighborhood": "Bonfim",
                            "city": "Osasco",
                            "federal_unit": "SP"
                        }
                    },
                    "additional_info": {
                        "items": [
                            {
                                "id": "1941",
                                "title": "Ingresso Antecipado",
                                "description": "Natal Iluminado 2019",
                                "picture_url": null,
                                "category_id": "Tickets",
                                "quantity": 1,
                                "unit_price": 100.00,
                                "event_date": "2019-12-25T19:30:00.000-03:00"
                            }
                        ],
                        "payer": {
                            "first_name": "Nome",
                            "last_name": "Sobrenome",
                            "is_prime_user": "1",
                            "is_first_purchase_online": "1",
                            "last_purchase": "2019-10-25T19:30:00.000-03:00",
                            "phone": {
                                "area_code": "11",
                                "number": "987654321"
                            },
                            "address": {
                                "zip_code": "06233-200",
                                "street_name": "Av. das Nações Unidas",
                                "street_number": "3003"
                            },
                            "registration_date": "2013-08-06T09:25:04.000-03:00"
                        },
                        "shipments": {
                            "express_shipment": "0",
                            "pick_up_on_seller": "1",
                            "receiver_address": {
                                "zip_code": "95630000",
                                "street_name": "são Luiz",
                                "street_number": "15",
                                "floor": "12",
                                "apartment": "123"
                            }
                        }
                    }
                }
                """;

        HttpClient httpClient = HttpClient.newHttpClient();
        List<Object> responses = new ArrayList<>();
      
        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://api.mercadopago.com/v1/payments"))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer" + awsSecretManager.getSecret())
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
       
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            responses.add(httpResponse.statusCode());
            responses.add(httpResponse.body());

        } catch (Exception e) {
            // TODO: handle exception
        }
      
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
      
      
    }

    @GetMapping()
    public ResponseEntity<String> tokenAws() {
        AwsSecretManager awsSecretManager = new AwsSecretManager();
        String gSecretManager = awsSecretManager.getSecret();
        return ResponseEntity.ok().body(gSecretManager);
    }
}
