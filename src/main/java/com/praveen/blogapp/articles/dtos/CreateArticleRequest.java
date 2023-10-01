package com.praveen.blogapp.articles.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Data
@Setter(AccessLevel.NONE)
public class CreateArticleRequest {

    @NotNull
    private String title;
    @NotNull
    private String body;
    @Nullable
    private String subtitle;
}
