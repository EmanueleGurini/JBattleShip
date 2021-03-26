package it.unicam.cs.pa2021.battleship;

/**
 * Questa interfaccia rappresenta un generico campo di battaglia.
 */
public interface BattleField {

    /**
     * Aggiunge una nuova nave nella posizione indicata e con la data direzione.
     *
     * @param ship la nave da aggiungere
     * @param position posizione nel campo dove inserire la nave
     * @param dir direzione della nave
     * @return true se il posizionamento &egrave; avenuto con successo, false altrimenti.
     */
    boolean addShip(Ship ship, FieldPosition position, Direction dir);

    /**
     * Aggiunge la nave nella posizione indicata e con la direzione di default.
     *
     * @param ship la nave da aggiungere
     * @param position posizione nel campo dove inserire la nave
     * @return true se il posizionamento &egrave; avenuto con successo, false altrimenti.
     */
    default boolean addShip(Ship ship, FieldPosition position) {
        return addShip(ship,position,Direction.defaultDirection());
    }

    /**
     * Restiuisce la nave nella posizione data. Se gli indici utilizzati eccedono le dimensioni
     * del campo di battaglia o sono numeri negativi, l'eccezione {@link ArrayIndexOutOfBoundsException}
     * verr&agrave; generata.
     *
     * @param fieldPosition posizione dove aggiungere la nave.
     * @return la nave nella posizione data, null se nessuna nave &egrave; nella posizione.
     */
    Ship shipAt(FieldPosition fieldPosition);


    /**
     * Verifica se una data posizione nel campo di battaglia sia libera o meno.
     *
     * @param fieldPosition posizione dove aggiungere la nave.
     * @return true se la posizione nel campo di battaglia &egrave; libera, false altrimenti.
     */
    default boolean isFree(FieldPosition fieldPosition) {
        return shipAt(fieldPosition) == null;
    }

    /**
     * Effetuo un lancio nella posizione indicata.
     *
     * @param fieldPosition posizione dove aggiungere la nave.
     * @return risutlato del lancio.
     */
    ShotResult shotAt(FieldPosition fieldPosition);

    /**
     * Restituisce la larghezza del campo.
     *
     * @return la larghezza del campo.
     */
    int width();

    /**
     * Restituisce l'altezza del campo.
     *
     * @return l'altezza del campo.
     */
    int height();

    /**
     * Restituisce lo stato di una cella
     *
     * @param fieldPosition posizione dove aggiungere la nave.
     * @return stato della cella
     */
    ShotResult result(FieldPosition fieldPosition);


}
