package com.example.myapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/api/greeting")
    @Operation(
            summary = "Get welcome message",
            description = "Returns a welcome message.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "text/plain",
                                    schema = @Schema(type = "string", example = "Hello, World!")
                            )
                    )
            }
    )
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/api/submit")
    @Operation(
            summary = "Submit Data",
            description = "Submits data and returns a confirmation message.",
            requestBody = @RequestBody(
                    description = "Data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "string",
                                    example = "String")
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Data successfully submitted."),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request, invalid data.")

            }
    )
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    @GetMapping("/api/user/{id}")
    @Operation(
            summary = "Get User by ID",
            description = "Fetches a user by their ID and returns the user details.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Unique identifier",
                            required = true,
                            example = "123"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(
            summary = "Search Items",
            description = "Searches for items based on a query parameter and returns the matching results.",
            parameters = {
                    @Parameter(
                            name = "query",
                            description = "The search query to find matching items",
                            required = false,
                            example = "example search"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Search results for: example search")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid search query"
                    )
            }
    )
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query") String query) {
        return "Search results for: " + query;
    }
}