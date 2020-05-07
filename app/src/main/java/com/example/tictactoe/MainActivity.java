package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean p1turn = true;
    private int count=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (p1turn) {
            ((Button) v).setText("X");
        } else
            ((Button) v).setText("O");
        count++;
        if (check()) {
            if (p1turn) {
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
        } else if (count == 9)
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        else
            p1turn = !p1turn;
    }
    private boolean check()
    {
        String[][] board = new String[3][3];
        for (int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && !board[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && !board[0][i].equals("")) {
                return true;
            }
        }

        if (board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])
                && !board[0][0].equals("")) {
            return true;
        }

        if (board[0][2].equals(board[1][1])
                && board[0][2].equals(board[2][0])
                && !board[0][2].equals("")) {
            return true;
        }

        return false;
    }

}