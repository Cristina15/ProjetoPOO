/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jopo;

import java.util.List;

/**
 *
 * @author Matheus Maia
 */
public interface dao {
    
        public void salvar(Object objeto);
	public void atualizar(Object objeto);
	public void deletar(int id);
	public Object getById(int id);
	public List<Object> getAll();
}
