app.controller('ex5Ctrl', function ($scope) {
    
        var matchPattern = /^((?!\d).)*([\w]+[\s]?[\=][\s]?)([\w]+[\s]?)([\+\-\*\/][\s]?)([\w]+[\s]?)([\+\-\*\/][\s]?[\w]+)?([\;]$)/;
        var variableRegex = /[\w\+\-\*\/]/;
        var numberRegex = /^\d/;
        var operatorsRegex = /\+|\-|\*|\//;
    
        function geraResultado(resultado, index, lastIndex) {        
                return {
                    'resultado': resultado,
                    'index': index,
                    'lastIndex': lastIndex
                };
            }
    
        $scope.verifyPattern = function () {
            $scope.matched = matchPattern.test($scope.targetString);
            
            if($scope.matched){
                angular.element(document.querySelector('#targetString')).removeClass('border border-danger');            
                angular.element(document.querySelector('#targetString')).addClass('border border-success');
    
                $scope.identificadores = [];
                
                var phrases = fixPhrases();
                console.log(phrases);

                var idq = 1;
    
                for(var i=0; i<phrases.length; i++) {
                    if(numberRegex.test(phrases[i])){
                        var obj = {
                            lex: phrases[i],
                            token: 'Número'
                        }
                        $scope.identificadores.push(obj);
                    } else
                    if(variableRegex.test(phrases[i])){

                        var obj = {
                            lex: phrases[i]
                        };
        
                        if(phrases[i]=="+"){
                            obj.token = "Operador aritmético ADD"
                        } else
                        if(phrases[i]=="-"){
                            obj.token = "Operador aritmético SUB"
                        } else
                        if(phrases[i]=="*"){
                            obj.token = "Operador aritmético MULT"
                        } else
                        if(phrases[i]=="/"){
                            obj.token = "Operador aritmético DIV"
                        } else {
                            obj.token = 'Identificador ' + idq
                        }
                        idq++;
                        $scope.identificadores.push(obj);
                    }
                    
                }
    
            } else {
                angular.element(document.querySelector('#targetString')).removeClass('border border-success');            
                angular.element(document.querySelector('#targetString')).addClass('border border-danger');            
            }
        }
    
        function fixPhrases() {
            var resultados	 = [];
            var resultado 	 = null;
        
            var objetoRegex = new RegExp(variableRegex, 'g');
            var indexAtual = 0;
        
            while (resultado = objetoRegex.exec($scope.targetString)) {
                console.log(resultado.index, indexAtual);
                if(resultado.index!=indexAtual){
                    resultado[0] = ';' + resultado[0];
                }
                indexAtual = objetoRegex.lastIndex;
                resultados.push(geraResultado(resultado[0], resultado.index, objetoRegex.lastIndex));
            }
            var palavra1 = "";
            var palavra2 = "";
    
            for(var i=0; i<resultados.length; i++){
                palavra1 = palavra1 + resultados[i].resultado;
            }
            
            for(var i=0;i<palavra1.length; i++) {
                palavra2 = palavra2 + palavra1.charAt(i);
            }
    
            return palavra2.split(";");
        }
    
    })
    