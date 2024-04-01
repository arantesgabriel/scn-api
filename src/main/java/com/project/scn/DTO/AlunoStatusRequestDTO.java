package com.project.scn.DTO;

public class AlunoStatusRequestDTO {

    private Long codigo;
    private boolean novoStatus;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public boolean isNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(boolean novoStatus) {
        this.novoStatus = novoStatus;
    }
}
