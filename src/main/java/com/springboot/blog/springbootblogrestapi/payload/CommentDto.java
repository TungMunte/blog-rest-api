package com.springboot.blog.springbootblogrestapi.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    @NotEmpty(message = "name should not be null or empty")
    private String name;
    @Email
    @NotEmpty(message = "email should not be null or empty")
    private String email;
    @NotEmpty(message = "body should not be null or empty")
    @Size(min = 10, message = "body should contain at least 10 characters")
    private String body;
}
