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
    private int x,y;
    private WBC wbc;
    private JPanel WBCPanel;
    private Battle bt;
    private StartGame stgame;
    private Timer timer = new Timer();
    private AttackController attackController;
    
    
    public WBCMovement(WBC wbc,Battle bt,StartGame stgame){
        this.stgame=stgame;
        this.wbc=wbc;
        this.bt=bt;
        wbc.getWBCPanel().addMouseListener(this);
        wbc.getWBCPanel().addMouseMotionListener(this);
        WBCPanel=wbc.getWBCPanel();
        
        
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        wbc.getWBCLabel().setIcon(wbc.getCharacIcon(1));
        x=e.getX();
        y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (wbc.getWBCPanel().getBounds().intersects(bt.getEnemyArr().get(0).getBounds())){
            wbc.getWBCPanel().setLocation(bt.getEnemyArr().get(0).getX()-200,bt.getEnemyArr().get(0).getY());
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
                TimerTask attackWBC1 = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                        attackController.setValue();
                        if(wbc.getHPcontrol().getHP()>0){
                            TimerTask attackEnemy1 = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                    attackController.setValue();
                                    
                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                        TimerTask attackWBC2 = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                attackController.setValue();
                                                
                                                if(wbc.getHPcontrol().getHP()>0){
                                                    TimerTask attackEnemy2 = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                            attackController.setValue();
                                                            
                                                            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                TimerTask attackWBC3 = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                        attackController.setValue();
                                                                        
                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                            TimerTask attackEnemy3 = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                    attackController.setValue();
                                                                                    
                                                                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                        TimerTask attackWBC4 = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                attackController.setValue();
                                                                                                
                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                    TimerTask attackEnemy4 = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                            attackController.setValue();
                                                                                                            
                                                                                                            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                                                TimerTask attackWBC5 = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                                        attackController.setValue();
                                                                                                                        
                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                            TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                                                    attackController.setValue();
                                                                                                                                    
                                                                                                                                    if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                                                                        TimerTask attackWBC6 = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                                                                attackController.setValue();
                                                                                                                                                
                                                                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                    TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                                        public void run(){
                                                                                                                                                            attackController.attacking();
                                                                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                                                                            attackController.setValue();
                                                                                                                                                            
                                                                                                                                                            if(bt.getEnemyArr().get(0).getHPcontrol().getHP()>0){
                                                                                                                                                                TimerTask attackWBC7 = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        attackController.attacking();
                                                                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(0),wbc,stgame.getUplayer());
                                                                                                                                                                        attackController.setValue();
                                                                                                                                                                        
                                                                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                                            TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                                                                public void run(){
                                                                                                                                                                                    attackController.attacking();
                                                                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(0),stgame.getUplayer());
                                                                                                                                                                                    attackController.setValue();
                                                                                                                                                                                }
                                                                                                                                                                            };
                                                                                                                                                                        }
                                                                                                                                                                        else{
                                                                                                                                                                            TimerTask diedEnemy7 = new TimerTask(){
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
                                                                                                                                                                                            bt.getEnemyArr().remove(1);
                                                                                                                                                                                            bt.getEnemyArr().remove(0);
                                                                                                                                                                                        }
                                                                                                                                                                                    };  timer.schedule(wait, 1200);
                                                                                                                                                                                }
                                                                                                                                                                            };  timer.schedule(diedEnemy7, 1000);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                };
                                                                                                                                                            }
                                                                                                                                                            else{
                                                                                                                                                                TimerTask diedWBC7 = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        attackController.attacking();
                                                                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                                                                            public void run(){
                                                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                                                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                                                }
                                                                                                                                                                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                                                }
                                                                                                                                                                                bt.removeEnemy(0);                                                  //remove Enemy
                                                                                                                                                                                attackController.BufferHP();
                                                                                                                                                                                System.out.println("You win");
                                                                                                                                                                                attackController.setWinner();
                                                                                                                                                                                bt.getEnemyArr().remove(1);
                                                                                                                                                                                bt.getEnemyArr().remove(0);
                                                                                                                                                                            }
                                                                                                                                                                        };  timer.schedule(wait, 1200);
                                                                                                                                                                    }
                                                                                                                                                                }; timer.schedule(diedWBC7, 1000);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    };
                                                                                                                                                }
                                                                                                                                                else{
                                                                                                                                                    TimerTask diedEnemy6 = new TimerTask(){
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
                                                                                                                                                                    bt.getEnemyArr().remove(1);
                                                                                                                                                                    bt.getEnemyArr().remove(0);
                                                                                                                                                                }
                                                                                                                                                            };  timer.schedule(wait, 1200);
                                                                                                                                                        }
                                                                                                                                                    };  timer.schedule(diedEnemy6, 1000);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        };  timer.schedule(attackWBC6, 1000);
                                                                                                                                    }
                                                                                                                                    else{
                                                                                                                                        TimerTask diedWBC6 = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                    public void run(){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                        }
                                                                                                                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                        }
                                                                                                                                                        bt.removeEnemy(0);                                                  //remove Enemy
                                                                                                                                                        attackController.BufferHP();
                                                                                                                                                        System.out.println("You win");
                                                                                                                                                        attackController.setWinner();
                                                                                                                                                        bt.getEnemyArr().remove(1);
                                                                                                                                                        bt.getEnemyArr().remove(0);
                                                                                                                                                    }
                                                                                                                                                };  timer.schedule(wait, 1200);
                                                                                                                                            }
                                                                                                                                        }; timer.schedule(diedWBC6, 1000);
                                                                                                                                    }
                                                                                                                                    
                                                                                                                                }
                                                                                                                            };  timer.schedule(attackEnemy5, 1000);
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            TimerTask diedEnemy5 = new TimerTask(){
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
                                                                                                                                            bt.getEnemyArr().remove(1);
                                                                                                                                            bt.getEnemyArr().remove(0);
                                                                                                                                        }
                                                                                                                                    };  timer.schedule(wait, 1200);
                                                                                                                                }
                                                                                                                            };  timer.schedule(diedEnemy5, 1000);
                                                                                                                        }
                                                                                                                    }
                                                                                                                };  timer.schedule(attackWBC5, 1000);
                                                                                                            }
                                                                                                            else{
                                                                                                                TimerTask diedWBC5 = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                            public void run(){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                }
                                                                                                                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                }
                                                                                                                                bt.removeEnemy(0);                                                  //remove Enemy
                                                                                                                                attackController.BufferHP();
                                                                                                                                System.out.println("You win");
                                                                                                                                attackController.setWinner();
                                                                                                                                bt.getEnemyArr().remove(1);
                                                                                                                                bt.getEnemyArr().remove(0);
                                                                                                                            }
                                                                                                                        };  timer.schedule(wait, 1200);
                                                                                                                    }
                                                                                                                }; timer.schedule(diedWBC5, 1000);
                                                                                                            }
                                                                                                        }
                                                                                                    };  timer.schedule(attackEnemy4, 1000);
                                                                                                }
                                                                                                else{
                                                                                                    TimerTask diedEnemy4 = new TimerTask(){
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
                                                                                                                    bt.getEnemyArr().remove(1);
                                                                                                                    bt.getEnemyArr().remove(0);
                                                                                                                }
                                                                                                            };  timer.schedule(wait, 1200);
                                                                                                        }
                                                                                                    };  timer.schedule(diedEnemy4, 1000);
                                                                                                }
                                                                                            }
                                                                                        };  timer.schedule(attackWBC4, 1000);
                                                                                    }
                                                                                    else{
                                                                                        TimerTask diedWBC4 = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                TimerTask wait = new TimerTask(){
                                                                                                    public void run(){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                        if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                        }
                                                                                                        else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                        }
                                                                                                        bt.removeEnemy(0);                                                  //remove Enemy
                                                                                                        attackController.BufferHP();
                                                                                                        System.out.println("You win");
                                                                                                        attackController.setWinner();
                                                                                                        bt.getEnemyArr().remove(1);
                                                                                                        bt.getEnemyArr().remove(0);
                                                                                                    }
                                                                                                };  timer.schedule(wait, 1200);
                                                                                            }
                                                                                        }; timer.schedule(diedWBC4, 1000);
                                                                                    }
                                                                                }
                                                                            };  timer.schedule(attackEnemy3, 1000);
                                                                        }
                                                                        else{
                                                                            TimerTask diedEnemy3 = new TimerTask(){
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
                                                                                            bt.getEnemyArr().remove(1);
                                                                                            bt.getEnemyArr().remove(0);
                                                                                        }
                                                                                    };  timer.schedule(wait, 1200);
                                                                                }
                                                                            };  timer.schedule(diedEnemy3, 1000);
                                                                        }
                                                                    }
                                                                }; timer.schedule(attackWBC3, 1000);
                                                            }
                                                            else{
                                                                TimerTask diedWBC3 = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        TimerTask wait = new TimerTask(){
                                                                            public void run(){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                if(bt.getEnemyArr().get(0) instanceof NormalEnemy){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                }
                                                                                else if(bt.getEnemyArr().get(0) instanceof BossEnemy){
                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                }
                                                                                bt.removeEnemy(0);                                                  //remove Enemy
                                                                                attackController.BufferHP();
                                                                                System.out.println("You win");
                                                                                attackController.setWinner();
                                                                                bt.getEnemyArr().remove(1);
                                                                                bt.getEnemyArr().remove(0);
                                                                            }
                                                                        };  timer.schedule(wait, 1200);
                                                                    }
                                                                }; timer.schedule(diedWBC3, 1000);
                                                            }
                                                        }
                                                    };  timer.schedule(attackEnemy2, 1000);
                                                }
                                                else{
                                                    TimerTask diedEnemy2 = new TimerTask(){
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
                                                                    bt.getEnemyArr().remove(1);
                                                                    bt.getEnemyArr().remove(0);
                                                                }
                                                            };  timer.schedule(wait, 1200);
                                                        }
                                                    }; timer.schedule(diedEnemy2, 1000);
                                                }
                                            }
                                        };  timer.schedule(attackWBC2, 1000);
                                    }
                                    else{
                                        TimerTask diedWBC2 = new TimerTask(){
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
                                                        bt.removeEnemy(0);      //remove Enemy
                                                        attackController.BufferHP();
                                                        System.out.println("You win");
                                                        attackController.setWinner();
                                                        bt.getEnemyArr().remove(1);
                                                        bt.getEnemyArr().remove(0);
                                                    }
                                                };  timer.schedule(wait, 1200);
                                            }
                                        }; timer.schedule(diedWBC2, 1000);
                                    }
                                }
                            };timer.schedule(attackEnemy1, 1000);
                        }
                        else{
                            TimerTask diedEnemy1 = new TimerTask(){
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
                                            bt.getEnemyArr().remove(1);
                                            bt.getEnemyArr().remove(0);
                                        }
                                    };  timer.schedule(wait, 1200);
                                }
                            }; timer.schedule(diedEnemy1, 1000);
                        }
                    }
                };  timer.schedule(attackWBC1, 1000);
            }
            else{
                TimerTask diedWBC1 = new TimerTask(){
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
                                }
                                bt.removeEnemy(0);                                                  //remove Enemy
                                attackController.BufferHP();
                                System.out.println("You win");
                                attackController.setWinner();
                                bt.getEnemyArr().remove(1);
                                bt.getEnemyArr().remove(0);
                            }
                        };  timer.schedule(wait, 1200);
                    }
                };timer.schedule(diedWBC1, 1000);
            }
        }
        else if (wbc.getWBCPanel().getBounds().intersects(bt.getEnemyArr().get(1).getBounds())){
            wbc.getWBCPanel().setLocation(bt.getEnemyArr().get(1).getX()-200,bt.getEnemyArr().get(1).getY());
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
                TimerTask attackWBC1 = new TimerTask(){
                    public void run(){
                        attackController.attacking();
                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                        attackController.setValue();
                        if(wbc.getHPcontrol().getHP()>0){
                            TimerTask attackEnemy1 = new TimerTask(){
                                public void run(){
                                    attackController.attacking();
                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                    attackController.setValue();
                                    
                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                        TimerTask attackWBC2 = new TimerTask(){
                                            public void run(){
                                                attackController.attacking();
                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                attackController.setValue();
                                                
                                                if(wbc.getHPcontrol().getHP()>0){
                                                    TimerTask attackEnemy2 = new TimerTask(){
                                                        public void run(){
                                                            attackController.attacking();
                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                            attackController.setValue();
                                                            
                                                            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                TimerTask attackWBC3 = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                        attackController.setValue();
                                                                        
                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                            TimerTask attackEnemy3 = new TimerTask(){
                                                                                public void run(){
                                                                                    attackController.attacking();
                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                    attackController.setValue();
                                                                                    
                                                                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                        TimerTask attackWBC4 = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                attackController.setValue();
                                                                                                
                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                    TimerTask attackEnemy4 = new TimerTask(){
                                                                                                        public void run(){
                                                                                                            attackController.attacking();
                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                            attackController.setValue();
                                                                                                            
                                                                                                            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                                                TimerTask attackWBC5 = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                                        attackController.setValue();
                                                                                                                        
                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                            TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                public void run(){
                                                                                                                                    attackController.attacking();
                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                                                    attackController.setValue();
                                                                                                                                    
                                                                                                                                    if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                                                                        TimerTask attackWBC6 = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                                                                attackController.setValue();
                                                                                                                                                
                                                                                                                                                if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                    TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                                        public void run(){
                                                                                                                                                            attackController.attacking();
                                                                                                                                                            attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                                                                            attackController.setValue();
                                                                                                                                                            
                                                                                                                                                            if(bt.getEnemyArr().get(1).getHPcontrol().getHP()>0){
                                                                                                                                                                TimerTask attackWBC7 = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        attackController.attacking();
                                                                                                                                                                        attackController = new AttackController(bt.getEnemyArr().get(1),wbc,stgame.getUplayer());
                                                                                                                                                                        attackController.setValue();
                                                                                                                                                                        
                                                                                                                                                                        if(wbc.getHPcontrol().getHP()>0){
                                                                                                                                                                            TimerTask attackEnemy5 = new TimerTask(){
                                                                                                                                                                                public void run(){
                                                                                                                                                                                    attackController.attacking();
                                                                                                                                                                                    attackController = new AttackController(wbc,bt.getEnemyArr().get(1),stgame.getUplayer());
                                                                                                                                                                                    attackController.setValue();
                                                                                                                                                                                }
                                                                                                                                                                            };
                                                                                                                                                                        }
                                                                                                                                                                        else{
                                                                                                                                                                            TimerTask diedEnemy7 = new TimerTask(){
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
                                                                                                                                                                                            bt.getEnemyArr().remove(1);
                                                                                                                                                                                            bt.getEnemyArr().remove(0);
                                                                                                                                                                                        }
                                                                                                                                                                                    };  timer.schedule(wait, 1200);
                                                                                                                                                                                }
                                                                                                                                                                            };  timer.schedule(diedEnemy7, 1000);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                };
                                                                                                                                                            }
                                                                                                                                                            else{
                                                                                                                                                                TimerTask diedWBC7 = new TimerTask(){
                                                                                                                                                                    public void run(){
                                                                                                                                                                        attackController.attacking();
                                                                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                                                                            public void run(){
                                                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                                                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                                                }
                                                                                                                                                                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                                                }
                                                                                                                                                                                bt.removeEnemy(1);                                                  //remove Enemy
                                                                                                                                                                                attackController.BufferHP();
                                                                                                                                                                                System.out.println("You win");
                                                                                                                                                                                attackController.setWinner();
                                                                                                                                                                                bt.getEnemyArr().remove(1);
                                                                                                                                                                                bt.getEnemyArr().remove(0);
                                                                                                                                                                            }
                                                                                                                                                                        };  timer.schedule(wait, 1200);
                                                                                                                                                                    }
                                                                                                                                                                }; timer.schedule(diedWBC7, 1000);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    };
                                                                                                                                                }
                                                                                                                                                else{
                                                                                                                                                    TimerTask diedEnemy6 = new TimerTask(){
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
                                                                                                                                                                    bt.getEnemyArr().remove(1);
                                                                                                                                                                    bt.getEnemyArr().remove(0);
                                                                                                                                                                }
                                                                                                                                                            };  timer.schedule(wait, 1200);
                                                                                                                                                        }
                                                                                                                                                    };  timer.schedule(diedEnemy6, 1000);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        };  timer.schedule(attackWBC6, 1000);
                                                                                                                                    }
                                                                                                                                    else{
                                                                                                                                        TimerTask diedWBC6 = new TimerTask(){
                                                                                                                                            public void run(){
                                                                                                                                                attackController.attacking();
                                                                                                                                                TimerTask wait = new TimerTask(){
                                                                                                                                                    public void run(){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                                        }
                                                                                                                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                                        }
                                                                                                                                                        bt.removeEnemy(1);                                                  //remove Enemy
                                                                                                                                                        attackController.BufferHP();
                                                                                                                                                        System.out.println("You win");
                                                                                                                                                        attackController.setWinner();
                                                                                                                                                        bt.getEnemyArr().remove(1);
                                                                                                                                                        bt.getEnemyArr().remove(0);
                                                                                                                                                    }
                                                                                                                                                };  timer.schedule(wait, 1200);
                                                                                                                                            }
                                                                                                                                        }; timer.schedule(diedWBC6, 1000);
                                                                                                                                    }
                                                                                                                                    
                                                                                                                                }
                                                                                                                            };  timer.schedule(attackEnemy5, 1000);
                                                                                                                        }
                                                                                                                        else{
                                                                                                                            TimerTask diedEnemy5 = new TimerTask(){
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
                                                                                                                                            bt.getEnemyArr().remove(1);
                                                                                                                                            bt.getEnemyArr().remove(0);
                                                                                                                                        }
                                                                                                                                    };  timer.schedule(wait, 1200);
                                                                                                                                }
                                                                                                                            };  timer.schedule(diedEnemy5, 1000);
                                                                                                                        }
                                                                                                                    }
                                                                                                                };  timer.schedule(attackWBC5, 1000);
                                                                                                            }
                                                                                                            else{
                                                                                                                TimerTask diedWBC5 = new TimerTask(){
                                                                                                                    public void run(){
                                                                                                                        attackController.attacking();
                                                                                                                        TimerTask wait = new TimerTask(){
                                                                                                                            public void run(){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                                                }
                                                                                                                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                                                }
                                                                                                                                bt.removeEnemy(1);                                                  //remove Enemy
                                                                                                                                attackController.BufferHP();
                                                                                                                                System.out.println("You win");
                                                                                                                                attackController.setWinner();
                                                                                                                                bt.getEnemyArr().remove(1);
                                                                                                                                bt.getEnemyArr().remove(0);
                                                                                                                            }
                                                                                                                        };  timer.schedule(wait, 1200);
                                                                                                                    }
                                                                                                                }; timer.schedule(diedWBC5, 1000);
                                                                                                            }
                                                                                                        }
                                                                                                    };  timer.schedule(attackEnemy4, 1000);
                                                                                                }
                                                                                                else{
                                                                                                    TimerTask diedEnemy4 = new TimerTask(){
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
                                                                                                                    bt.getEnemyArr().remove(1);
                                                                                                                    bt.getEnemyArr().remove(0);
                                                                                                                }
                                                                                                            };  timer.schedule(wait, 1200);
                                                                                                        }
                                                                                                    };  timer.schedule(diedEnemy4, 1000);
                                                                                                }
                                                                                            }
                                                                                        };  timer.schedule(attackWBC4, 1000);
                                                                                    }
                                                                                    else{
                                                                                        TimerTask diedWBC4 = new TimerTask(){
                                                                                            public void run(){
                                                                                                attackController.attacking();
                                                                                                TimerTask wait = new TimerTask(){
                                                                                                    public void run(){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                                        if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                                        stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                                        }
                                                                                                        else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                                            stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                                        }
                                                                                                        bt.removeEnemy(1);                                                  //remove Enemy
                                                                                                        attackController.BufferHP();
                                                                                                        System.out.println("You win");
                                                                                                        attackController.setWinner();
                                                                                                        bt.getEnemyArr().remove(1);
                                                                                                        bt.getEnemyArr().remove(0);
                                                                                                    }
                                                                                                };  timer.schedule(wait, 1200);
                                                                                            }
                                                                                        }; timer.schedule(diedWBC4, 1000);
                                                                                    }
                                                                                }
                                                                            };  timer.schedule(attackEnemy3, 1000);
                                                                        }
                                                                        else{
                                                                            TimerTask diedEnemy3 = new TimerTask(){
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
                                                                                            bt.getEnemyArr().remove(1);
                                                                                            bt.getEnemyArr().remove(0);
                                                                                        }
                                                                                    };  timer.schedule(wait, 1200);
                                                                                }
                                                                            };  timer.schedule(diedEnemy3, 1000);
                                                                        }
                                                                    }
                                                                }; timer.schedule(attackWBC3, 1000);
                                                            }
                                                            else{
                                                                TimerTask diedWBC3 = new TimerTask(){
                                                                    public void run(){
                                                                        attackController.attacking();
                                                                        TimerTask wait = new TimerTask(){
                                                                            public void run(){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffWBCHPBar();                 //Turn off WBC HP bar
                                                                                if(bt.getEnemyArr().get(1) instanceof NormalEnemy){
                                                                                stgame.getUplayer().getHPBarPanel().turnOffEnemyHPBar();            //Turn off Enemy HP Bar
                                                                                }
                                                                                else if(bt.getEnemyArr().get(1) instanceof BossEnemy){
                                                                                    stgame.getUplayer().getHPBarPanel().turnOffBossHPBar();         //Turn off Boss HP Bar
                                                                                }
                                                                                bt.removeEnemy(1);                                                  //remove Enemy
                                                                                attackController.BufferHP();
                                                                                System.out.println("You win");
                                                                                attackController.setWinner();
                                                                                bt.getEnemyArr().remove(1);
                                                                                bt.getEnemyArr().remove(0);
                                                                            }
                                                                        };  timer.schedule(wait, 1200);
                                                                    }
                                                                }; timer.schedule(diedWBC3, 1000);
                                                            }
                                                        }
                                                    };  timer.schedule(attackEnemy2, 1000);
                                                }
                                                else{
                                                    TimerTask diedEnemy2 = new TimerTask(){
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
                                                                    bt.getEnemyArr().remove(1);
                                                                    bt.getEnemyArr().remove(0);
                                                                }
                                                            };  timer.schedule(wait, 1200);
                                                        }
                                                    }; timer.schedule(diedEnemy2, 1000);
                                                }
                                            }
                                        };  timer.schedule(attackWBC2, 1000);
                                    }
                                    else{
                                        TimerTask diedWBC2 = new TimerTask(){
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
                                                        bt.removeEnemy(1);      //remove Enemy
                                                        attackController.BufferHP();
                                                        System.out.println("You win");
                                                        attackController.setWinner();
                                                        bt.getEnemyArr().remove(1);
                                                        bt.getEnemyArr().remove(0);
                                                    }
                                                };  timer.schedule(wait, 1200);
                                            }
                                        }; timer.schedule(diedWBC2, 1000);
                                    }
                                }
                            };timer.schedule(attackEnemy1, 1000);
                        }
                        else{
                            TimerTask diedEnemy1 = new TimerTask(){
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
                                            bt.getEnemyArr().remove(1);
                                            bt.getEnemyArr().remove(0);
                                        }
                                    };  timer.schedule(wait, 1200);
                                }
                            }; timer.schedule(diedEnemy1, 1000);
                        }
                    }
                };  timer.schedule(attackWBC1, 1000);
            }
            else{
                TimerTask diedWBC1 = new TimerTask(){
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
                                }
                                bt.removeEnemy(1);
                                bt.getEnemyArr().remove(1);
                                bt.getEnemyArr().remove(0);
                                attackController.BufferHP();
                                System.out.println("You win");
                                attackController.setWinner();
                            }
                        };  timer.schedule(wait, 1200);
                    }
                };timer.schedule(diedWBC1, 1000);
            }
        }
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
