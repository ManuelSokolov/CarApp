package utils.observer;




public interface Observer {
	
	/**
	 * Atualiza o comerciante que foi feita um reserva
	 * 
	 * @param nomeConsumidor nome do consumidor
	 * @param listaDeCompras lista de compras
	 */
	public void update(Event e);
}
