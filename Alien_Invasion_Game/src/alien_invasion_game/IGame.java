/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alien_invasion_game;

import javax.swing.JLabel;

/**
 *
 * @author Jun
 */
public interface IGame {
    public void CreateAliens();
    
    public void DrawAliens(int i, int xpos, int ypos);
    
    public void ShootBullets();
    
    public void MoveBullet(JLabel bullet);
    
    public void ShootAlien();
    
    public void MoveAliens();
    
    public void PlaySong();
}
