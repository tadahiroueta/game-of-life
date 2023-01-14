import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** 
	 * Gets neighbor life cells
	 * 
	 * @param {number} homeX
	 * @param {number} homeY
	 * @return {Object[]} neighbor life cells
	 */
	private ArrayList<LifeCell> getNeighbors(int homeX, int homeY) {
		ArrayList<LifeCell> neighbors = new ArrayList<LifeCell>();
		
		for (int x = homeX - 1; x <= homeX + 1; x++) 
			for (int y = homeY - 1; y <= homeY + 1; y++) {
				if (x == homeX && y == homeY) continue; // remove home itself
				try {
					neighbors.add(grid[x][y]);
				}
				catch (Exception exception) {} // ignore spaces outside grid
			}
		return neighbors;
	}

	/** Update on whether the cells will live */
	private void updateFutureSurvival() {
		for (int x = 0; x < grid.length; x++) 
			for (int y = 0; y < grid[0].length; y++) {
				LifeCell lifeCell = grid[x][y];
				ArrayList<LifeCell> neighbors = getNeighbors(x, y);
				
				int liveNeighbors = 0;
				for (LifeCell neighbor : neighbors)
					if (neighbor.isAliveNow())
						liveNeighbors++;
				
				if (liveNeighbors == 3)
					lifeCell.setAliveNext(true);
				else if (liveNeighbors == 2)
					lifeCell.setAliveNext(lifeCell.isAliveNow());
				else
					lifeCell.setAliveNext(false);
	}}


	/** Update life cells */
	private void updateCells() {
		for (int x = 0; x < grid.length; x++) 
			for (int y = 0; y < grid[0].length; y++) {
				LifeCell lifeCell = grid[x][y];
				lifeCell.setAliveNow(lifeCell.isAliveNext());
	}}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		updateFutureSurvival();
		updateCells();
	}

	/** Reset grid */
	public void reset() {
		for (int x = 0; x < grid.length; x++) 
			for (int y = 0; y < grid[0].length; y++) {
				if (Math.random() > 0.85) //15% chance of a cell starting alive
					grid[x][y].setAliveNow(true);
				else
					grid[x][y].setAliveNow(false);
		}
		myView.updateView(grid);
	}


	/** Get random integer from 0 to 255 */
	private int randomInt() {
		return (int) (Math.random() * 256);
	}

	/** 
	 * Randomize color
	 * 
	 * @param {LifeView} view
	 */
	public void randomizeColor() {
		LifeView.setFillColor(new Color(
			randomInt(),
			randomInt(),
			randomInt()	
		));
		myView.updateView(grid);
	}
}

