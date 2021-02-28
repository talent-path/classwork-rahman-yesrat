import { Component, OnInit } from '@angular/core';
import { Game, TTTGame } from '../../game/Game';
import { Location } from '../../game/Location';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {
  game: Game = new TTTGame();
  winsO : number = 0; 
  winsX : number = 0; 
  draws : number = 0; 
  status: string = " ";

  constructor() { }

  ngOnInit(): void {
  }

  onSquareClicked(position: Location): void {
    this.game.makeMove(position);
    switch (this.game.gameStatus) {
      case 1:
        this.status = "Congrats, Player O wins!";
        this.winsO++; 
        break;
      case -1:
        this.status = "Congrats, Player X wins!";
        this.winsX++; 
        break;
      case 0:
        this.status = "A Draw!";
        this.draws++; 
        break;
    }
  }

  reset(): void {
    this.game = new TTTGame();
  }

}


//  // user chooses number of rounds
//  int numRounds = getNumRounds();
//  int wins = 0;
//  int losses = 0;
//  int draws = 0;

//  // loop through each round
//  for( int i = 0; i < numRounds; i++ ) {
//      //      randomly choose who goes first
//      boolean playerGoesFirst = choosePlayerIsFirst();

//      //1 - player wins
//      //0 - draw
//      //-1 - player loses
//      int roundResult = playRound( playerGoesFirst );

//      //      record the results
//      switch (roundResult){
//          case 1:
//              wins++;
//              break;
//          case 0:
//              draws++;
//              break;
//          case -1:
//              losses++;
//              break;
//          default:
//              throw new Exception("Error: got back invalid round result: " + roundResult);
//      }

//  }

// private static void report(int wins, int losses, int draws) {
//   Console.print("Player won " + wins + " times.\n");
//   Console.print("Computer won " + losses + " times.\n");
//   Console.print("There were " + draws + " draws.\n");
//   if( wins < losses ) {
//       Console.print("Try harder next time...\n");
//   }

// }