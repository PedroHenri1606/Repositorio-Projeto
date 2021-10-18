package Main;

    public abstract class Cliente {
        protected String nome;
        protected String email;
        protected String senha;
        protected String dataNascimento;//Instant
        protected boolean login;
        protected String curso;//crie uma classe
        protected String ra;


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

