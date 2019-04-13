package br.com.fiap.paymentservice.Controller;

import br.com.fiap.paymentservice.Entity.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Payment", description = "lista de pagamentos")
public class PaymentController {
    private ArrayList<Payment> payments = new ArrayList<>();

    @GetMapping("/payment/{id}")
    public Map<String, Payment> findById(@PathVariable("id") int id) {
        HashMap<String, Payment> hash = new HashMap<>();

        try {
            Payment order = this.payments.get(id);
            hash.put("Payment", order);
        } catch (Exception err) {
            hash.put("Payment", null);
        }
        return hash;
    }

    @PostMapping("/payment")
    public Map<String, String> salvar(@RequestBody Payment payment) {
        HashMap<String, String> hash = new HashMap<>();
        try {
            this.payments.add(payment);
            int id = this.payments.size() - 1;
            this.payments.get(id).setId(id);

            hash.put("URL", "http://localhost:8080/payment/" + id);
        } catch (Exception err) {
            hash.put("Payment", "Não foi possível salvar pagamento.");
        }

        return hash;
    }

    @PutMapping("/payment/{id}")
    public Map<String, String> update(@RequestBody Payment payment, @PathVariable("id") int id) {
        HashMap<String, String> hash = new HashMap<>();
        try {
            this.payments.set(id, payment);
            hash.put("Mensagem", "Pagamento foi atualizado.");
            hash.put("Url", "http://localhost:8080/payment/" + id);
        } catch (Exception err) {
            hash.put("Mensagem", "Não foi possível atualizar pagamento.");
        }

        return hash;
    }

    @DeleteMapping("/payment/{id}")
    public Map<String, String> delete(@PathVariable("id") int id) {

        HashMap<String, String> hash = new HashMap<>();
        try {
            this.payments.remove(id);
            hash.put("Mensagem", "Pagamento: " + id + " deletado.");
        } catch (Exception err) {
            hash.put("Payment", "Não foi possível deletar pagamento.");
        }

        return hash;
    }
}
