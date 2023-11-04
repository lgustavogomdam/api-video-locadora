package io.github.lgustavogomdam.api_video_locadora.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API da AllocVideo")
                        .version("v1")
                        .description(
                                "A API da AllocVideo é um sistema de gerenciamento de aluguel de " +
                                "filmes que oferece recursos poderosos para os clientes alugarem e devolverem filmes," +
                                " bem como para os administradores acompanharem o catálogo de filmes e as transações" +
                                " de aluguel. A API é projetada para facilitar o acesso a informações sobre filmes," +
                                " clientes e transações.\n\n" +

                                "**Recursos Principais:**\n\n" +

                                "- *Cadastro de Filmes:* Os administradores podem adicionar novos filmes ao catálogo," +
                                "incluindo informações como título, gênero, ano de lançamento e descrição.\n" +

                                "- *Aluguel de Filmes:* Os clientes podem pesquisar e alugar filmes disponíveis no " +
                                "catálogo. A API fornece informações sobre a disponibilidade dos filmes e facilita" +
                                " a reserva e o aluguel.\n" +

                                "- *Devolução de Filmes:* Os clientes podem registrar a devolução de filmes alugados," +
                                " atualizando o status do aluguel e calculando os valores devidos.\n" +

                                "- *Histórico de Transações:* A API mantém um registro das transações, permitindo que" +
                                " os administradores e clientes consultem o histórico de aluguel e devolução.\n" +

                                "- *Pesquisa de Filmes:* Os clientes podem pesquisar filmes com base em vários " +
                                "critérios, como título, gênero e ano de lançamento.\n" +

                                "- *Gerenciamento de Clientes:* Os administradores podem adicionar, atualizar e " +
                                "remover informações de clientes, incluindo detalhes de contato.\n" +

                                "- *Segurança:* A API implementa medidas de segurança, como autenticação e " +
                                "autorização, para proteger os dados dos clientes e das transações.\n\n" +

                                "**Uso da API:**\n\n" +

                                "A API é acessada por meio de chamadas HTTP e responde com dados em formato JSON. " +
                                "Os desenvolvedores podem integrar essa API em aplicativos de locadora de filmes, " +
                                "sites ou aplicativos móveis para facilitar a gestão de aluguéis e fornecer uma " +
                                "experiência de usuário eficiente.\n\n" +

                                "Para obter detalhes específicos sobre os pontos de extremidade da API, os " +
                                "parâmetros de solicitação e a autenticação necessária, consulte a documentação " +
                                "oficial disponível no repositório do meu GitHub " +
                                "*( https://github.com/lgustavogomdam/API-video-locadora )*. Lá, você " +
                                "encontrará informações detalhadas sobre como usar a API da Locadora de Vídeos.\n\n"
                        )
                );
    }
}
