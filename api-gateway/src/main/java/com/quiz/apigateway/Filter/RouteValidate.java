package com.quiz.apigateway.Filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidate {

    public static final List<String> publicApiEndPoints = List.of(
            "/auth/add",
            "/auth/validate",
            "/auth/generateToken"
    );

    public Predicate<ServerHttpRequest> isSecured = request ->
            publicApiEndPoints.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
