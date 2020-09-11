#pragma once
class Coin {
public:
    int generateNumbers();
    void defineTypeOfTrading();
    void init();
    void percentChange(int& trades);
    void defineAmountOfFunds();
    void displayInformation();
    void getNewPrice();
    void defineTypeOfCoin();
    void logActions();
    void updateWindow(RenderWindow& window, int trades) const;
    void stoppingTheProgram(RenderWindow& window);

private:
    void sell();
    void buy();
    double howMuchToBuy();
    double howMuchToSell();
    
    double averageBuyingPrice;
    double amountOfCoin;
    vector<double> priceVect;
    vector<double> moneyMade;
    int maxFunds;
    int usableMoney;
    bool trading = false;
    string coinType;
    string lastAction;
};

