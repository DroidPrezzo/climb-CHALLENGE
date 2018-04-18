package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = MainActivity.class.getSimpleName();
    boolean xMove = true;
    int NO_OF_TURNS = 0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button reset;
    Button start;
    TextView intro;
    TextView playerTurn;
    private View mView;


    int[][] boardState = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);

        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);

        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        reset = (Button) findViewById(R.id.reset);
        start = (Button) findViewById(R.id.start);
        intro = (TextView) findViewById(R.id.intro);
        playerTurn = (TextView) findViewById(R.id.playerTurn);
        mView = (TableLayout) findViewById(R.id.board);
        reset.setOnClickListener(this);
        start.setOnClickListener(this);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        initializeBoardState();

    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "Inside onClick");
        int id = view.getId();
        if (id == R.id.start) {
            startGame();
            enableAllBoxes(true);}

            boolean resetButtonPressed = false;

            switch (view.getId()) {

                case R.id.b1:
                    if (xMove) {
                        b1.setText("X");
                        boardState[0][0] = 1;
                    } else {
                        b1.setText("0");
                        boardState[0][0] = 0;
                    }
                    b1.setEnabled(false);
                    break;

                case R.id.b2:
                    if (xMove) {
                        b2.setText("X");
                        boardState[0][1] = 1;
                    } else {
                        b2.setText("0");
                        boardState[0][1] = 0;
                    }
                    b2.setEnabled(false);
                    break;

                case R.id.b3:
                    if (xMove) {
                        b3.setText("X");
                        boardState[0][2] = 1;
                    } else {
                        b3.setText("0");
                        boardState[0][2] = 0;
                    }
                    b3.setEnabled(false);
                    break;

                case R.id.b4:
                    if (xMove) {
                        b4.setText("X");
                        boardState[1][0] = 1;
                    } else {
                        b4.setText("0");
                        boardState[1][0] = 0;
                    }
                    b4.setEnabled(false);
                    break;

                case R.id.b5:
                    if (xMove) {
                        b5.setText("X");
                        boardState[1][1] = 1;
                    } else {
                        b5.setText("0");
                        boardState[1][1] = 0;
                    }
                    b5.setEnabled(false);
                    break;

                case R.id.b6:
                    if (xMove) {
                        b6.setText("X");
                        boardState[1][2] = 1;
                    } else {
                        b6.setText("0");
                        boardState[1][2] = 0;
                    }
                    b6.setEnabled(false);
                    break;

                case R.id.b7:
                    if (xMove) {
                        b7.setText("X");
                        boardState[2][0] = 1;
                    } else {
                        b7.setText("0");
                        boardState[2][0] = 0;
                    }
                    b7.setEnabled(false);
                    break;

                case R.id.b8:
                    if (xMove) {
                        b8.setText("X");
                        boardState[2][1] = 1;
                    } else {
                        b8.setText("0");
                        boardState[2][1] = 0;
                    }
                    b8.setEnabled(false);
                    break;

                case R.id.b9:
                    if (xMove) {
                        b9.setText("X");
                        boardState[2][2] = 1;
                    } else {
                        b9.setText("0");
                        boardState[2][2] = 0;
                    }
                    b9.setEnabled(false);
                    break;

                case R.id.reset:
                    resetButtonPressed = true;
                    break;

                default:
                    break;

            }

            if (resetButtonPressed) {
                clearBoard();
            } else {
                NO_OF_TURNS++;
                xMove = !xMove;

                if (xMove) {
                    setInfo("Player X turn");
                } else {
                    setInfo("Player 0 turn");
                }

                if (NO_OF_TURNS == 9) {
                    result("Game Draw");
                }

                checkWinner();
            }
        }


    private void checkWinner() {

        Log.d(TAG, "Inside checkWinner");

        // player wins by Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (boardState[i][0] == boardState[i][1] && boardState[i][0] == boardState[i][2]) {
                if (boardState[i][0] == 1) {
                    result("Player X winner\n" + (i + 1) + " row");
                    break;
                } else if (boardState[i][0] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " row");
                    break;
                }
            }
        }

        //player wins Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (boardState[0][i] == boardState[1][i] && boardState[0][i] == boardState[2][i]) {
                if (boardState[0][i] == 1) {
                    result("Player X winner\n" + (i + 1) + " column");
                    break;
                } else if (boardState[0][i] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " column");
                    break;
                }
            }
        }

        //if player wins by First diagonal
        if (boardState[0][0] == boardState[1][1] && boardState[0][0] == boardState[2][2]) {
            if (boardState[0][0] == 1) {
                result("Player X winner\nFirst Diagonal");
            } else if (boardState[0][0] == 0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //if player wins by Second diagonal
        if (boardState[0][2] == boardState[1][1] && boardState[0][2] == boardState[2][0]) {
            if (boardState[0][2] == 1) {
                result("Player X winner\nSecond Diagonal");
            } else if (boardState[0][2] == 0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }


    private void enableAllBoxes(boolean value) {
        Log.d(TAG, "Inside enableAllBoxes");
        b1.setEnabled(value);
        b2.setEnabled(value);
        b3.setEnabled(value);

        b4.setEnabled(value);
        b5.setEnabled(value);
        b6.setEnabled(value);

        b7.setEnabled(value);
        b8.setEnabled(value);
        b9.setEnabled(value);
    }

    private void result(String winner) {
        Log.d(TAG, "Inside result");

        setInfo(winner);
        enableAllBoxes(false);
    }

    private void clearBoard() {
        Log.d(TAG, "Inside clearBoard");
        b1.setText("");
        b2.setText("");
        b3.setText("");

        b4.setText("");
        b5.setText("");
        b6.setText("");

        b7.setText("");
        b8.setText("");
        b9.setText("");

        enableAllBoxes(true);

        xMove = true;
        NO_OF_TURNS = 0;

        initializeBoardState();

        setInfo("Start Over");

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text) {
        playerTurn.setText(text);
    }

    private void initializeBoardState() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = -1;
            }

        }
    }

    private void startGame() {
        start.setVisibility(View.GONE);
        intro.setVisibility(View.GONE);
        reset.setVisibility(View.VISIBLE);
        mView.setVisibility(View.VISIBLE);


    }
}



