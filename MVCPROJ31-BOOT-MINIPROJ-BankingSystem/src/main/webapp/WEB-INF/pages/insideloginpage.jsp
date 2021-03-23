<%@page isELIgnored="false" %>
<center>
<h1 style="color:green" >${result}</h1>
<h2><a  href="transactions?no=${acno}"><img src="images/transactions.png" height="50px" width="50px">View All Transactions</a> </h2>
<br><br><br>
<h2><a href="checkbalance?no=${acno}"><img src="images/bankbalance.png" height="50px" width="50px">Check Balance</a></h2>
<h4 style="color:green;text-align:center">${balance}</h4>
<br><br><br>
<h2><a href="transfermoney?no=${acno}"><img src="images/transfer.jpg" height="50px" width="50px">Transfer Money</a></h2>
</center>