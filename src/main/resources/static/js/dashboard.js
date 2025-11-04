$(document).ready(function() {
    loadUser();
    loadIncomes();
    loadExpenses();
    $('#transactionsList');
});

let incomesList = [];
let expensesList = [];

async function loadUser() {
  const request = await fetch('api/v1/user', {
    method: 'GET',
    headers: getHeaders()
  });
  const user = await request.json();

  document.getElementById('txtUserName').outerHTML = user.name;

}

async function loadIncomes() {
  const request = await fetch('api/v1/incomes', {
    method: 'GET',
    headers: getHeaders()
  });
  const incomes = await request.json();

  let totalIncomes = 0.00;

  for (let income of incomes) {
    incomesList.push(income);
    totalIncomes += income.amount;
  }
  document.getElementById('totalIncomes').outerHTML = totalIncomes;
  incomesTransactionsList();
}

async function loadExpenses() {
  const request = await fetch('api/v1/expenses', {
    method: 'GET',
    headers: getHeaders()
  });
  const expenses = await request.json();
  let totalExpenses = 0.00;

  for (let expense of expenses) {
    if (expense.paid) {
        expensesList.push(expense);
        totalExpenses += expense.amount;
    }
  }
  document.getElementById('totalExpenses').outerHTML = totalExpenses;
}

// Convierte la fecha a un objeto Date
function parseDate(dateString) {
  const [day, month, year] = dateString.split('/');
  return new Date(`${year}-${month}-${day}`);
}

function incomesTransactionsList() {
    incomesList.sort((a, b) => parseDate(b.date) - parseDate(a.date));
    let htmlList = '';
    for (let income of incomesList){
    let incomeHtml = '<div class="list-group-item border-0 rounded-3 mb-2 bg-light d-flex justify-content-between align-items-center"><div><i class="bi bi-arrow-up-right-circle-fill text-success me-2"></i> '+ income.description +' <br><small class="text-secondary">'+ income.date +'</small></div><span class="text-success fw-bold">$'+ income.amount +'</span></div>';
    htmlList += incomeHtml;
    }
    if (htmlList.length === 0){
        htmlList = '<div class="alert alert-secondary">Aún no hay datos de inversiones.</div>';
    }
    document.querySelector('#transactionsList').innerHTML = htmlList;
}

function expensesTransactionsList() {
    expensesList.sort((a, b) => parseDate(b.date) - parseDate(a.date));
    let htmlList = '';
    for (let expense of expensesList) {
        let expenseHtml = '<div class="list-group-item border-0 rounded-3 mb-2 bg-light d-flex justify-content-between align-items-center"><div><i class="bi bi-arrow-up-right-circle-fill text-success me-2"></i> '+ expense.description +' <br><small class="text-secondary">'+ expense.date +'</small></div><span class="text-success fw-bold">$'+ expense.amount +'</span></div>';
        htmlList += expenseHtml;
    }
    if (htmlList.length === 0){
            htmlList = '<div class="alert alert-secondary">Aún no hay datos de inversiones.</div>';
    }
    document.querySelector('#transactionsList').innerHTML = htmlList;
}

function allList() {
    allTransactions = incomesList.concat(expensesList);
    allTransactions.sort((a, b) => parseDate(b.date) - parseDate(a.date));
    let htmlList = '';
    for (let transaction of allTransactions) {

        let transactionHtml = '<div class="list-group-item border-0 rounded-3 mb-2 bg-light d-flex justify-content-between align-items-center"><div><i class="bi bi-arrow-up-right-circle-fill text-success me-2"></i> '+ transaction.description +' <br><small class="text-secondary">'+ transaction.date +'</small></div><span class="text-success fw-bold">$'+ transaction.amount +'</span></div>';
        htmlList += transactionHtml
    }
    document.querySelector('#transactionsList').innerHTML = htmlList;
}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}
