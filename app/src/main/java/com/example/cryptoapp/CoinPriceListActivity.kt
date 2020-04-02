package com.example.cryptoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cryptoapp.adapter.CoinInfoAdapter
import com.example.cryptoapp.pojo.CoinPriceInfo
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_coin_price_list.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CoinPriceListActivity : AppCompatActivity() {

  private  val compositeDisposable = CompositeDisposable()
    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter = CoinInfoAdapter(this)
        rvCoinPriceList.adapter = adapter
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener{
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                Log.e("TEST_OF_ON_CLICK", coinPriceInfo.fromSymbol)
                val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity,coinPriceInfo.fromSymbol)
                startActivity(intent)
            }

        }
        viewModel  = ViewModelProviders.of(this)[CoinViewModel::class.java]
     //  viewModel.loadData()
        viewModel.priceList.observe(this, Observer {
            Log.e("TEST_OF_LOAD_DATA", "Success in Activity: $it")
            adapter.coinInfoList =it
        })

    }

}
