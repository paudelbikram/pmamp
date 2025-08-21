<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>{{Ticker}}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>{{Ticker}} Overview</h1>
        <div id="overview">
            <h3>Overview</h3>
            <ul class="list-group overview">
                <li class="list-group-item">Name : ${Name}</li>
                <li class="list-group-item">AssetType : ${AssetType}</li>
                <li class="list-group-item">Description : ${Description}</li>
                <li class="list-group-item">Exchange : ${Exchange}</li>
                <li class="list-group-item">Country : ${Country}</li>
                <li class="list-group-item">Sector : ${Sector}</li>
                <li class="list-group-item">Industry : ${Industry}</li>
                <li class="list-group-item">FiscalYearEnd : ${FiscalYearEnd}</li>
                <li class="list-group-item">LatestQuarter : ${LatestQuarter}</li>
                <li class="list-group-item">Currency : ${Currency}</li>
                <li class="list-group-item">MarketCapitalization : ${MarketCapitalization}</li>
                <li class="list-group-item">EBITDA : ${EBITDA}</li>
                <li class="list-group-item">PERatio : ${PERatio}</li>
                <li class="list-group-item">PEGRatio : ${PEGRatio}</li>
                <li class="list-group-item">BookValue : ${BookValue}</li>
                <li class="list-group-item">DividendYield : ${DividendYield}</li>
                <li class="list-group-item">EPS : ${EPS}</li>
                <li class="list-group-item">revenuePerShare : ${revenuePerShare}</li>
                <li class="list-group-item">ProfitMargin : ${ProfitMargin}</li>
                <li class="list-group-item">OperatingMarginTTM : ${OperatingMarginTTM}</li>
                <li class="list-group-item">ReturnOnAssetsTTM : ${ReturnOnAssetsTTM}</li>
                <li class="list-group-item">ReturnOnEquityTTM : ${ReturnOnEquityTTM}</li>
                <li class="list-group-item">RevenueTTM : ${RevenueTTM}</li>
                <li class="list-group-item">GrossProfitTTM : ${GrossProfitTTM}</li>
                <li class="list-group-item">DilutedEPSTTM : ${DilutedEPSTTM}</li>
                <li class="list-group-item">quarterlyEarningsGrowthYOY : ${QuarterlyEarningsGrowthYOY}</li>
                <li class="list-group-item">QuarterlyRevenueGrowthYOY : ${QuarterlyRevenueGrowthYOY}</li>
                <li class="list-group-item">AnalystTargetPrice : ${AnalystTargetPrice}</li>
                <li class="list-group-item">TrailingPE : ${TrailingPE}</li>
                <li class="list-group-item">ForwardPE : ${ForwardPE}</li>
                <li class="list-group-item">PriceToSalesRatioTTM : ${PriceToSalesRatioTTM}</li>
                <li class="list-group-item">PriceToBookRatio : ${PriceToBookRatio}</li>
                <li class="list-group-item">EVToRevenue : ${EVToRevenue}</li>
                <li class="list-group-item">EVToEBITDA : ${EVToEBITDA}</li>
                <li class="list-group-item">Beta : ${Beta}</li>
                <li class="list-group-item">52WeekHigh : ${52WeekHigh}</li>
                <li class="list-group-item">52WeekLow : ${52WeekLow}</li>
                <li class="list-group-item">50DayMovingAverage : ${50DayMovingAverage}</li>
                <li class="list-group-item">200DayMovingAverage : ${200DayMovingAverage}</li>
                <li class="list-group-item">SharesOutstanding : ${SharesOutstanding}</li>
            </ul>
        </div>
        <hr />
        <div id="balance-sheet">
            <h3>Balance Sheet</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
        <hr />
        <div id="cash-flow">
            <h3>Cash Flow</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
        <hr />
        <div id="income-statement">
            <h3>Annually Income Statement</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Total Revenue</th>
                    <th scope="col">Gross Profit</th>
                    <th scope="col">Operating Income</th>
                    <th scope="col">Net Income</th>
                    <th scope="col">EBITDA</th>
                    <th scope="col">Operating Expenses</th>
                    <th scope="col">Income Before Tax</th>
                    <th scope="col">EPS</th>
                </tr>
                </thead>
                <tbody>
                {{AnnualIncomeStatements}}
                </tbody>
            </table>
            <h3>Quarterly Income Statement</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Total Revenue</th>
                    <th scope="col">Gross Profit</th>
                    <th scope="col">Operating Income</th>
                    <th scope="col">Net Income</th>
                    <th scope="col">EBITDA</th>
                    <th scope="col">Operating Expenses</th>
                    <th scope="col">Income Before Tax</th>
                </tr>
                </thead>
                <tbody>
                {{QuarterlyIncomeStatements}}
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>