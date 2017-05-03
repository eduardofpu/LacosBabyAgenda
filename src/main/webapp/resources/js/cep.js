function BuscaCEP(valor)
      {
          //Nova variável "cep" somente com dígitos.
          var cep = valor.replace(/\D/g, '');

          //Verifica se campo cep possui valor informado.
          if (cep != "") {

              //Expressão regular para validar o CEP.
              var validacep = /^[0-9]{8}$/;


              //Valida o formato do CEP.
              if(validacep.test(cep)) {

                  //Consulta o webservice viacep.com.br/
                  $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                      if (!("erro" in dados)) {
                          //Atualiza os campos com os valores da consulta.
                          document.getElementById("endereco").value = dados.logradouro;
                          document.getElementById("bairro").value = dados.bairro;
                          document.getElementById("cidade").value = dados.localidade;
                          document.getElementById("uf").value = dados.uf;

                      } //end if.
                      else {
                          //CEP pesquisado não foi encontrado.

                          alert("CEP não encontrado.");
                      }
                  });
              } //end if.
              else {
                  //cep é inválido.

                  alert("Formato de CEP inválido.");
              }
          } //end if.
          else {
              //cep sem valor, limpa formulário.

          }


      }

//<input ng-model="cep" type="text" style="width: 100px" ng-class="{'validation-error': cepInputError}"
//  onblur="BuscaCEP(this.value)" />
