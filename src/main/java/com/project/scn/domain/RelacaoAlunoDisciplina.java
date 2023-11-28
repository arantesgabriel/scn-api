package com.project.scn.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "trelacaoalndcp")
public class RelacaoAlunoDisciplina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codrel")
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "codaln", referencedColumnName = "codaln")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "coddcp", referencedColumnName = "coddcp")
    private Disciplina disciplina;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
