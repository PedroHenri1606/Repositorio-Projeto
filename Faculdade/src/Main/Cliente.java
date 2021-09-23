package Main;

    public class Cliente {
        protected String nome;
        protected String email;
        protected String senha;
        protected String dataNascimento;
        protected boolean login;
        protected String curso;
        protected String ra;

        void status() {
            System.out.println("Usuario: " + this.nome);
            System.out.println("Esta logado? = " + this.login);
            System.out.println(" ");
            System.out.println("---Erro ao estabelecer conexão---");
        }

        void conexao() throws InterruptedException {
            System.out.print("Tentando conexão: 192.168.10.2 ");
            Thread.sleep(2000);
            System.out.println("-ERRO");
            System.out.print("Tentando conexão: 192.168.10.2 ");
            Thread.sleep(2000);
            System.out.println("-ERRO");
            System.out.print("Tentando conexão: 192.168.10.2 ");
            Thread.sleep(2000);
            System.out.println("-Sucesso");
            Thread.sleep(1400);
        }

        void teste(){
            this.login = true;
        }

        void telaInicio(){
            System.out.println("__________________________________");
            System.out.println("]Email: " + this.email);
            System.out.println("]Senha: ___________");
            System.out.println("]");
            System.out.println("]           [Login]    ");
            System.out.println("]_________________________________");
        }

        public Cliente() {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.dataNascimento = dataNascimento;
            this.curso = curso;
            this.ra = ra;
            this.login = login;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getIdade() {
            return dataNascimento;
        }

        public void setIdade(String idade) {
            this.dataNascimento = idade;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getRa() {
            return ra;
        }

        public void setRa(String ra) {
            this.ra = ra;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }
    }

