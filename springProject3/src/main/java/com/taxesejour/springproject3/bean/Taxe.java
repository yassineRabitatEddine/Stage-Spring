package com.taxesejour.springproject3.bean;

import javax.persistence.*;

@Entity
public class Taxe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private int annee;
    private int trimestre ;
    private double CA;
    private double montantBase ;

    public Taxe() {

    }

    public Taxe(double CA, Taux taux) {
        this.taux = taux;
        this.CA = CA;
        //a voir
        this.montantBase = taux.getPourcentage()*CA;
    }

    //un redevable paye plusieurs taxes
    @ManyToOne
    private Redevable redevable ;

    @OneToOne
    private Local local;
    @OneToOne
    private Taux taux ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public double getCA() {
        return CA;
    }

    public void setCA(double CA) {
        this.CA = CA;
    }

    public double getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }
}