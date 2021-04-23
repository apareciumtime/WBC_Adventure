package wbcadventure;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class WBCMovement implements MouseListener,MouseMotionListener{
    private int x=300,y=300;
    private WBC wbc;
    private JPanel WBCPanel;
    private Battle bt;
    private StartGame stgame;
    private Timer timer = new Timer();
    private AttackController attackController;
    private ArrayList<EnemyBlankPanel> enemyarr;
    
    
    public WBCMovement(WBC wbc,Battle bt,StartGame stgame){
        this.stgame=stgame;
        this.wbc=wbc;
        this.bt=bt;
        wbc.getWBCPanel().addMouseListener(this);
        wbc.getWBCPanel().addMouseMotionListener(this);
        WBCPanel=wbc.getWBCPanel();
        enemyarr=bt.getPathGen().getEnemyPanelArrayList();
        wbc.setXforBoostSpeed(300);
        wbc.setYforBoostSpeed(300);
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        boolean goFight=false;
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(0));
        if(enemyarr.get(0).getBeChoice()==true){
            if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(0).getBounds())){
                this.fight(enemyarr.get(0));
                goFight=true;
            }
            else if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(1).getBounds())){
                this.fight(enemyarr.get(1));
                goFight=true;
            }
        }
        else{
            if(wbc.getWBCPanel().getBounds().intersects(enemyarr.get(0).getBounds())){
                this.fight(enemyarr.get(0));
                goFight=true;
            }
        }
        if(!goFight){
            wbc.setLocation(x, y);
        }

        /*if (condition){
            wbc.getWBCPanel().setLocation(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(2));
            stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            
            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().setEnemyHPBar((NormalEnemy) bt.enemyArrayList.get(0));
            }
            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().setBossHPBar();
            }
            
            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
            attackController.setValue();
            
            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                TimerTask attackWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                        attackController.setValue();
                        
                        if(wbc.getHPcontrol().getHP()>0){
                            TimerTask attackEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                    attackController.setValue();
                        
                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                        TimerTask attackWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                attackController.setValue();
                                                if(wbc.getHPcontrol().getHP()>0){
                                                    TimerTask attackEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                            attackController.setValue();
                                                            
                                                            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                TimerTask attackWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                        attackController.setValue();
                                                                        
                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                    attackController.setValue();
                                                                                    
                                                                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                attackController.setValue();
                                                                                                
                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                    TimerTask attackEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                            attackController.setValue();
                                                                                                            
                                                                                                            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                                                TimerTask attackWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                                        attackController.setValue();
                                                                                                                        
                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                                                    attackController.setValue();
                                                                                                                                    
                                                                                                                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                                                                attackController.setValue();
                                                                                                                                                
                                                                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                        TimerTask attackEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                                                                                attackController.setValue();
                                                                                                                                                            }
                                                                                                                                                        };  timer.schedule(attackEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                                    else{
                                                                                                                                                        TimerTask diedEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                                                        System.out.println("You loss");
                                                                                                                                                                        attackController.setWinner();
                                                                                                                                                                    }
                                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                                            }
                                                                                                                                                        }; timer.schedule(diedEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                            }
                                                                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                                                                    }
                                                                                                                                    else{
                                                                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                    public void run(){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                        }
                                                                                                                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                        }                                                                     //remove Enemy
                                                                                                                                                        bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                                                                                                                                        attackController.BufferHP();
                                                                                                                                                        System.out.println("You win");
                                                                                                                                                        attackController.setWinner();
                                                                                                                                                    }
                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                            }
                                                                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    TimerTask wait = new TimerTask(){
                                                                                                                                        public void run(){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                            }
                                                                                                                                            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                            }
                                                                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                            System.out.println("You loss");
                                                                                                                                            attackController.setWinner();
                                                                                                                                        }
                                                                                                                                    };  timer.schedule(wait, 1050);
                                                                                                                                }
                                                                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                                                                        }
                                                                                                                    }
                                                                                                                };  timer.schedule(attackWBC, 1000);
                                                                                                            }
                                                                                                            else{
                                                                                                                TimerTask diedWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                            public void run(){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                }
                                                                                                                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                }                                                                     //remove Enemy
                                                                                                                                bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                                                                                                                attackController.BufferHP();
                                                                                                                                System.out.println("You win");
                                                                                                                                attackController.setWinner();
                                                                                                                            }
                                                                                                                        };  timer.schedule(wait, 1050);
                                                                                                                    }
                                                                                                                };timer.schedule(diedWBC, 1000);
                                                                                                            }
                                                                                                        }
                                                                                                    };  timer.schedule(attackEnemy, 1000);
                                                                                                }
                                                                                                else{
                                                                                                    TimerTask diedEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            TimerTask wait = new TimerTask(){
                                                                                                                public void run(){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                    if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                    }
                                                                                                                    else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                    }
                                                                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                    System.out.println("You loss");
                                                                                                                    attackController.setWinner();
                                                                                                                }
                                                                                                            };  timer.schedule(wait, 1050);
                                                                                                        }
                                                                                                    }; timer.schedule(diedEnemy, 1000);
                                                                                                }
                                                                                            }
                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                    }
                                                                                    else{
                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                TimerTask wait = new TimerTask(){
                                                                                                    public void run(){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                        }
                                                                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                        }                                                                     //remove Enemy
                                                                                                        bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                                                                                        attackController.BufferHP();
                                                                                                        System.out.println("You win");
                                                                                                        attackController.setWinner();
                                                                                                    }
                                                                                                };  timer.schedule(wait, 1050);
                                                                                            }
                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                    }
                                                                                }
                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                        }
                                                                        else{
                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    TimerTask wait = new TimerTask(){
                                                                                        public void run(){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                            }
                                                                                            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                            }
                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                            System.out.println("You loss");
                                                                                            attackController.setWinner();
                                                                                        }
                                                                                    };  timer.schedule(wait, 1050);
                                                                                }
                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                        }
                                                                    }
                                                                };  timer.schedule(attackWBC, 1000);
                                                            }
                                                            else{
                                                                TimerTask diedWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        TimerTask wait = new TimerTask(){
                                                                            public void run(){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                }
                                                                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                }                                                                     //remove Enemy
                                                                                bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                                                                attackController.BufferHP();
                                                                                System.out.println("You win");
                                                                                attackController.setWinner();
                                                                            }
                                                                        };  timer.schedule(wait, 1050);
                                                                    }
                                                                };timer.schedule(diedWBC, 1000);
                                                            }
                                                        }
                                                    };  timer.schedule(attackEnemy, 1000);
                                                }
                                                else{
                                                    TimerTask diedEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            TimerTask wait = new TimerTask(){
                                                                public void run(){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                    if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                    }
                                                                    else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                    }
                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                    System.out.println("You loss");
                                                                    attackController.setWinner();
                                                                }
                                                            };  timer.schedule(wait, 1050);
                                                        }
                                                    }; timer.schedule(diedEnemy, 1000);
                                                }
                                            }
                                        };  timer.schedule(attackWBC, 1000);
                                    }
                                    else{
                                        TimerTask diedWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                TimerTask wait = new TimerTask(){
                                                    public void run(){
                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                        }
                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                        }                                                                     //remove Enemy
                                                        bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                                        attackController.BufferHP();
                                                        System.out.println("You win");
                                                        attackController.setWinner();
                                                    }
                                                };  timer.schedule(wait, 1050);
                                            }
                                        };timer.schedule(diedWBC, 1000);
                                    }
                                }
                            };  timer.schedule(attackEnemy, 1000);
                        }
                        else{
                            TimerTask diedEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    TimerTask wait = new TimerTask(){
                                        public void run(){
                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                            }
                                            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                            }
                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                            System.out.println("You loss");
                                            attackController.setWinner();
                                        }
                                    };  timer.schedule(wait, 1050);
                                }
                            }; timer.schedule(diedEnemy, 1000);
                        }
                    }
                };  timer.schedule(attackWBC, 1000);
            }
            else{
                TimerTask diedWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        TimerTask wait = new TimerTask(){
                            public void run(){
                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                }
                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                }                                                                     //remove Enemy
                                bt.getEnemyArr().get(0).setBounds(0, 0, 0, 0);
                                attackController.BufferHP();
                                System.out.println("You win");
                                attackController.setWinner();
                            }
                        };  timer.schedule(wait, 1050);
                    }
                };timer.schedule(diedWBC, 1000);
            }
        }//......................
        if (wbc.getWBCPanel().getBounds().intersects(bt.getEnemyArr().get(1).getBounds())){
            wbc.getWBCPanel().setLocation(bt.getEnemyArr().get(1).getX()-200,bt.getEnemyArr().get(1).getY());
            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(2));
            stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            
            if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().setEnemyHPBar((NormalEnemy) bt.enemyArrayList.get(1));
            }
            else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().setBossHPBar();
            }
            
            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
            attackController.setValue();
            
            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                TimerTask attackWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                        attackController.setValue();
                        
                        if(wbc.getHPcontrol().getHP()>0){
                            TimerTask attackEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                    attackController.setValue();
                        
                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                        TimerTask attackWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                attackController.setValue();
                                                if(wbc.getHPcontrol().getHP()>0){
                                                    TimerTask attackEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                            attackController.setValue();
                                                            
                                                            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                TimerTask attackWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                        attackController.setValue();
                                                                        
                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                    attackController.setValue();
                                                                                    
                                                                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                attackController.setValue();
                                                                                                
                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                    TimerTask attackEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                            attackController.setValue();
                                                                                                            
                                                                                                            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                                                TimerTask attackWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                                        attackController.setValue();
                                                                                                                        
                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                                                    attackController.setValue();
                                                                                                                                    
                                                                                                                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                                                                attackController.setValue();
                                                                                                                                                
                                                                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                        TimerTask attackEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                                                                                attackController.setValue();
                                                                                                                                                            }
                                                                                                                                                        };  timer.schedule(attackEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                                    else{
                                                                                                                                                        TimerTask diedEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                                                        System.out.println("You loss");
                                                                                                                                                                        attackController.setWinner();
                                                                                                                                                                    }
                                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                                            }
                                                                                                                                                        }; timer.schedule(diedEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                            }
                                                                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                                                                    }
                                                                                                                                    else{
                                                                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                    public void run(){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                        }
                                                                                                                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                        }                                                                     //remove Enemy
                                                                                                                                                        bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                                                                                                                                        attackController.BufferHP();
                                                                                                                                                        System.out.println("You win");
                                                                                                                                                        attackController.setWinner();
                                                                                                                                                    }
                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                            }
                                                                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    TimerTask wait = new TimerTask(){
                                                                                                                                        public void run(){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                            if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                            }
                                                                                                                                            else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                            }
                                                                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                            System.out.println("You loss");
                                                                                                                                            attackController.setWinner();
                                                                                                                                        }
                                                                                                                                    };  timer.schedule(wait, 1050);
                                                                                                                                }
                                                                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                                                                        }
                                                                                                                    }
                                                                                                                };  timer.schedule(attackWBC, 1000);
                                                                                                            }
                                                                                                            else{
                                                                                                                TimerTask diedWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                            public void run(){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                }
                                                                                                                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                }                                                                     //remove Enemy
                                                                                                                                bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                                                                                                                attackController.BufferHP();
                                                                                                                                System.out.println("You win");
                                                                                                                                attackController.setWinner();
                                                                                                                            }
                                                                                                                        };  timer.schedule(wait, 1050);
                                                                                                                    }
                                                                                                                };timer.schedule(diedWBC, 1000);
                                                                                                            }
                                                                                                        }
                                                                                                    };  timer.schedule(attackEnemy, 1000);
                                                                                                }
                                                                                                else{
                                                                                                    TimerTask diedEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            TimerTask wait = new TimerTask(){
                                                                                                                public void run(){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                    if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                    }
                                                                                                                    else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                    }
                                                                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                    System.out.println("You loss");
                                                                                                                    attackController.setWinner();
                                                                                                                }
                                                                                                            };  timer.schedule(wait, 1050);
                                                                                                        }
                                                                                                    }; timer.schedule(diedEnemy, 1000);
                                                                                                }
                                                                                            }
                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                    }
                                                                                    else{
                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                TimerTask wait = new TimerTask(){
                                                                                                    public void run(){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                        }
                                                                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                        }                                                                     //remove Enemy
                                                                                                        bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                                                                                        attackController.BufferHP();
                                                                                                        System.out.println("You win");
                                                                                                        attackController.setWinner();
                                                                                                    }
                                                                                                };  timer.schedule(wait, 1050);
                                                                                            }
                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                    }
                                                                                }
                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                        }
                                                                        else{
                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    TimerTask wait = new TimerTask(){
                                                                                        public void run(){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                            if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                            }
                                                                                            else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                            }
                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                            System.out.println("You loss");
                                                                                            attackController.setWinner();
                                                                                        }
                                                                                    };  timer.schedule(wait, 1050);
                                                                                }
                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                        }
                                                                    }
                                                                };  timer.schedule(attackWBC, 1000);
                                                            }
                                                            else{
                                                                TimerTask diedWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        TimerTask wait = new TimerTask(){
                                                                            public void run(){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                }
                                                                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                }                                                                     //remove Enemy
                                                                                bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                                                                attackController.BufferHP();
                                                                                System.out.println("You win");
                                                                                attackController.setWinner();
                                                                            }
                                                                        };  timer.schedule(wait, 1050);
                                                                    }
                                                                };timer.schedule(diedWBC, 1000);
                                                            }
                                                        }
                                                    };  timer.schedule(attackEnemy, 1000);
                                                }
                                                else{
                                                    TimerTask diedEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            TimerTask wait = new TimerTask(){
                                                                public void run(){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                    if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                    }
                                                                    else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                    }
                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                    System.out.println("You loss");
                                                                    attackController.setWinner();
                                                                }
                                                            };  timer.schedule(wait, 1050);
                                                        }
                                                    }; timer.schedule(diedEnemy, 1000);
                                                }
                                            }
                                        };  timer.schedule(attackWBC, 1000);
                                    }
                                    else{
                                        TimerTask diedWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                TimerTask wait = new TimerTask(){
                                                    public void run(){
                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                        }
                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                        }                                                                     //remove Enemy
                                                        bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                                        attackController.BufferHP();
                                                        System.out.println("You win");
                                                        attackController.setWinner();
                                                    }
                                                };  timer.schedule(wait, 1050);
                                            }
                                        };timer.schedule(diedWBC, 1000);
                                    }
                                }
                            };  timer.schedule(attackEnemy, 1000);
                        }
                        else{
                            TimerTask diedEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    TimerTask wait = new TimerTask(){
                                        public void run(){
                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                            }
                                            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                            }
                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                            System.out.println("You loss");
                                            attackController.setWinner();
                                        }
                                    };  timer.schedule(wait, 1050);
                                }
                            }; timer.schedule(diedEnemy, 1000);
                        }
                    }
                };  timer.schedule(attackWBC, 1000);
            }
            else{
                TimerTask diedWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        TimerTask wait = new TimerTask(){
                            public void run(){
                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                }
                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                }                                                                     //remove Enemy
                                bt.getEnemyArr().get(1).setBounds(0, 0, 0, 0);
                                attackController.BufferHP();
                                System.out.println("You win");
                                attackController.setWinner();
                            }
                        };  timer.schedule(wait, 1050);
                    }
                };timer.schedule(diedWBC, 1000);
            }
        }*/
    }
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation(e.getX()+e.getComponent().getX()-75
                ,e.getY()+e.getComponent().getY()-100);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void fight(EnemyBlankPanel enemyPanel){
            wbc.getWBCPanel().setLocation(enemyPanel.getX()-250,enemyPanel.getY());
            x=enemyPanel.getX()-250;
            y=enemyPanel.getY();
            wbc.setXforBoostSpeed(x);
            wbc.setYforBoostSpeed(y);
            wbc.getWBCLabel().setIcon(wbc.getCharacIcon(2));
            stgame.getUplayer().getHPBarPanel().setWBCHPBar();
            
            if(enemyPanel.getEnemy() instanceof NormalEnemy){
                stgame.getUplayer().getHPBarPanel().setEnemyHPBar((NormalEnemy) enemyPanel.getEnemy());
            }
            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                stgame.getUplayer().getHPBarPanel().setBossHPBar();
            }
            
            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
            attackController.setValue();
            
            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                TimerTask attackWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                        attackController.setValue();
                        
                        if(wbc.getHPcontrol().getHP()>0){
                            TimerTask attackEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                    attackController.setValue();
                        
                                    if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                                        TimerTask attackWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                                                attackController.setValue();
                                                if(wbc.getHPcontrol().getHP()>0){
                                                    TimerTask attackEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                                            attackController.setValue();
                                                            
                                                            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                                                                TimerTask attackWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                                                                        attackController.setValue();
                                                                        
                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                                                                    attackController.setValue();
                                                                                    
                                                                                    if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                                                                                                attackController.setValue();
                                                                                                
                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                    TimerTask attackEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                                                                                            attackController.setValue();
                                                                                                            
                                                                                                            if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                                                                                                                TimerTask attackWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                                                                                                                        attackController.setValue();
                                                                                                                        
                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                            TimerTask attackEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                                                                                                                    attackController.setValue();
                                                                                                                                    
                                                                                                                                    if(enemyPanel.getEnemy().getHPcontrol().getHP()>0){
                                                                                                                                        TimerTask attackWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                attackController = new AttackController(enemyPanel.getEnemy(),wbc,stgame.getUplayer());
                                                                                                                                                attackController.setValue();
                                                                                                                                                
                                                                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                        TimerTask attackEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                attackController = new AttackController(wbc,enemyPanel.getEnemy(),stgame.getUplayer());
                                                                                                                                                                attackController.setValue();
                                                                                                                                                            }
                                                                                                                                                        };  timer.schedule(attackEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                                    else{
                                                                                                                                                        TimerTask diedEnemy = new TimerTask(){
                                                                                                                                                            public void run(){
                                                                                                                                                                attackController.attacking();
                                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                                                        if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                                        }
                                                                                                                                                                        wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                                                        System.out.println("You loss");
                                                                                                                                                                        attackController.setWinner();
                                                                                                                                                                    }
                                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                                            }
                                                                                                                                                        }; timer.schedule(diedEnemy, 1000);
                                                                                                                                                    }
                                                                                                                                            }
                                                                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                                                                    }
                                                                                                                                    else{
                                                                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                    public void run(){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                                        if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                        }
                                                                                                                                                        else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                        }                                                                     //remove Enemy
                                                                                                                                                        enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                                                                                                                                        attackController.BufferHP();
                                                                                                                                                        System.out.println("You win");
                                                                                                                                                        attackController.setWinner();
                                                                                                                                                    }
                                                                                                                                                };  timer.schedule(wait, 1050);
                                                                                                                                            }
                                                                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    TimerTask wait = new TimerTask(){
                                                                                                                                        public void run(){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                                            if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                            }
                                                                                                                                            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                            }
                                                                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                                            System.out.println("You loss");
                                                                                                                                            attackController.setWinner();
                                                                                                                                        }
                                                                                                                                    };  timer.schedule(wait, 1050);
                                                                                                                                }
                                                                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                                                                        }
                                                                                                                    }
                                                                                                                };  timer.schedule(attackWBC, 1000);
                                                                                                            }
                                                                                                            else{
                                                                                                                TimerTask diedWBC = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                            public void run(){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                                                if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                }
                                                                                                                                else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                }                                                                     //remove Enemy
                                                                                                                                enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                                                                                                                attackController.BufferHP();
                                                                                                                                System.out.println("You win");
                                                                                                                                attackController.setWinner();
                                                                                                                            }
                                                                                                                        };  timer.schedule(wait, 1050);
                                                                                                                    }
                                                                                                                };timer.schedule(diedWBC, 1000);
                                                                                                            }
                                                                                                        }
                                                                                                    };  timer.schedule(attackEnemy, 1000);
                                                                                                }
                                                                                                else{
                                                                                                    TimerTask diedEnemy = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            TimerTask wait = new TimerTask(){
                                                                                                                public void run(){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                                                    if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                    }
                                                                                                                    else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                    }
                                                                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                                                    System.out.println("You loss");
                                                                                                                    attackController.setWinner();
                                                                                                                }
                                                                                                            };  timer.schedule(wait, 1050);
                                                                                                        }
                                                                                                    }; timer.schedule(diedEnemy, 1000);
                                                                                                }
                                                                                            }
                                                                                        };  timer.schedule(attackWBC, 1000);
                                                                                    }
                                                                                    else{
                                                                                        TimerTask diedWBC = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                TimerTask wait = new TimerTask(){
                                                                                                    public void run(){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                                        if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                        }
                                                                                                        else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                        }                                                                     //remove Enemy
                                                                                                        enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                                                                                        attackController.BufferHP();
                                                                                                        System.out.println("You win");
                                                                                                        attackController.setWinner();
                                                                                                    }
                                                                                                };  timer.schedule(wait, 1050);
                                                                                            }
                                                                                        };timer.schedule(diedWBC, 1000);
                                                                                    }
                                                                                }
                                                                            };  timer.schedule(attackEnemy, 1000);
                                                                        }
                                                                        else{
                                                                            TimerTask diedEnemy = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    TimerTask wait = new TimerTask(){
                                                                                        public void run(){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                                            if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                            }
                                                                                            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                            }
                                                                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                                            System.out.println("You loss");
                                                                                            attackController.setWinner();
                                                                                        }
                                                                                    };  timer.schedule(wait, 1050);
                                                                                }
                                                                            }; timer.schedule(diedEnemy, 1000);
                                                                        }
                                                                    }
                                                                };  timer.schedule(attackWBC, 1000);
                                                            }
                                                            else{
                                                                TimerTask diedWBC = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        TimerTask wait = new TimerTask(){
                                                                            public void run(){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                                                if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                }
                                                                                else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                }                                                                     //remove Enemy
                                                                                enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                                                                attackController.BufferHP();
                                                                                System.out.println("You win");
                                                                                attackController.setWinner();
                                                                            }
                                                                        };  timer.schedule(wait, 1050);
                                                                    }
                                                                };timer.schedule(diedWBC, 1000);
                                                            }
                                                        }
                                                    };  timer.schedule(attackEnemy, 1000);
                                                }
                                                else{
                                                    TimerTask diedEnemy = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            TimerTask wait = new TimerTask(){
                                                                public void run(){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                                                    if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                                    stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                    }
                                                                    else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                                        stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                    }
                                                                    wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                                                    System.out.println("You loss");
                                                                    attackController.setWinner();
                                                                }
                                                            };  timer.schedule(wait, 1050);
                                                        }
                                                    }; timer.schedule(diedEnemy, 1000);
                                                }
                                            }
                                        };  timer.schedule(attackWBC, 1000);
                                    }
                                    else{
                                        TimerTask diedWBC = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                TimerTask wait = new TimerTask(){
                                                    public void run(){
                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                                        if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                        }
                                                        else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                        }                                                                     //remove Enemy
                                                        enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                                        attackController.BufferHP();
                                                        System.out.println("You win");
                                                        attackController.setWinner();
                                                    }
                                                };  timer.schedule(wait, 1050);
                                            }
                                        };timer.schedule(diedWBC, 1000);
                                    }
                                }
                            };  timer.schedule(attackEnemy, 1000);
                        }
                        else{
                            TimerTask diedEnemy = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    TimerTask wait = new TimerTask(){
                                        public void run(){
                                            stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                  //Turn off WBC HP bar
                                            if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                            stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                            }
                                            else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                                stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                            }
                                            wbc.setBounds(0, 0, 0, 0);                                          //remove WBC
                                            System.out.println("You loss");
                                            attackController.setWinner();
                                        }
                                    };  timer.schedule(wait, 1050);
                                }
                            }; timer.schedule(diedEnemy, 1000);
                        }
                    }
                };  timer.schedule(attackWBC, 1000);
            }
            else{
                TimerTask diedWBC = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        TimerTask wait = new TimerTask(){
                            public void run(){
                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();              //Turn off WBC HP bar
                                if(enemyPanel.getEnemy() instanceof NormalEnemy){
                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                }
                                else if(enemyPanel.getEnemy() instanceof BossEnemy){
                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                }                                                                     //remove Enemy
                                enemyPanel.getEnemy().setBounds(0, 0, 0, 0);
                                attackController.BufferHP();
                                System.out.println("You win");
                                attackController.setWinner();
                            }
                        };  timer.schedule(wait, 1050);
                    }
                };timer.schedule(diedWBC, 1000);
            }
            System.out.println("arr to del "+enemyPanel.getMustBeDeleteArr());
        if(enemyPanel.getMustBeDeleteArr().size()==1){
            enemyarr.remove(0);
        }
        else{
            for(int in=enemyPanel.getMustBeDeleteArr().size()-1;in>=0;in--){
                int del=enemyPanel.getMustBeDeleteArr().get(in);
                System.out.println("delete "+del);
                enemyarr.remove(del);
            }
        }
    }
    
}



/**
 * Comment Mouse Release
 */
//WBClabel.setIcon(wbc.getCharacIcon(0));
//        if (wbc.getWBCLabel().getBounds().intersects(bt.getEnemyArr().get(0).getBounds())){
//              wbc.getWBCLabel().setLocation(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
//              
//            if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
//                stgame.getUplayer().getHPBarPanel().setEnemyHPBar();
//                stgame.getUplayer().getHPBarPanel().setWBCHPBar();
//            }
//            else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
//                stgame.getUplayer().getHPBarPanel();
//                stgame.getUplayer().getHPBarPanel().setWBCHPBar();
//            }
//            
//            if(win instanceof WBC){
//                System.out.println("winnnn");
//                bt.getEnemyArr().get(0).setVisible(false);
//                bt.removeEnemy(0);
//                System.out.println(bt.getEnemyArr());
//            }
//            else{
//                System.out.print("lose");
//            }
//                wbc.setImgCorner(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
//                
//        }
