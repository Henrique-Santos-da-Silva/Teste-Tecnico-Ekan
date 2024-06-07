# Teste Tecnico Ekan

## Introdução

API responsável por gerenciar beneficiários e seus documentos, e foi desenvolvida usando Java e Spring.

## Configuração do Ambiente de Desenvolvimento

- JDK 17
- IDE (Eclipse, IntelliJ IDEA)
- Banco de dados H2-database

## Endpoints

### Beneficiário

- URL BASE: `http://localhost:8080/api/beneficiario`

### Corpo da requisição

#### POST

Para criar um novo beneficiário ou editar você precisa enviar os dados conforme o exemplo abaixo. **OBS: os tipos de documento suportados são: CNH, CPF e RG. Não é necessário enviar data de inclusão e atualização, essas datas são geradas automaticamente pelo sistema:**

```json
{
	"nome": "Jacobson",
	"telefone": "99 99999-9999",
	"dataNascimento": "01/01/2001",
	"documentos": [ 
		{
			"tipoDocumento": "CPF",
			"descricao": "000.000.000-00"
		},
		{
			"tipoDocumento": "RG",
			"descricao": "00.000.000-0"
		}
	]
}
```

- PUT: `URL_BASE/{id}`
- DELETE: `URL_BASE/{id}`

### Documentos

Para listar todos os documentos de um beneficiario basta usar a seguinte rota:

- `http://localhost:8080/api/documentos/{beneficario_id}`

