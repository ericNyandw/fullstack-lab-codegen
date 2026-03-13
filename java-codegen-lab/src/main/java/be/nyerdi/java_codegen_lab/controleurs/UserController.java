package be.nyerdi.java_codegen_lab.controleurs;

import be.nyerdi.java_codegen_lab.services.PetstoreService;
import com.petstore.client.model.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/petstore/users")
public class UserController {

    private final PetstoreService petstoreService;

    public UserController(PetstoreService petstoreService) {
        this.petstoreService = petstoreService;
    }

    @GetMapping("/{username}")
    public Mono<User> getUserByUsername(@PathVariable String username) {
        return petstoreService.getRemoteUser(username);
    }

    @PostMapping
    public Mono<Void> createNewUser(@RequestBody User user) {
        return petstoreService.saveRemoteUser(user);
    }
}

