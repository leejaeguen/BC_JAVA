package com.worms.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.worms.section02");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PokemonService pokemonService =
                context.getBean("pokemonServicePrimary", PokemonService.class);
        pokemonService.pokemonAttack();
    }
}
