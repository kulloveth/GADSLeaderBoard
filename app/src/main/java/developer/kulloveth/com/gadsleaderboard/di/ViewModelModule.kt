package developer.kulloveth.com.gadsleaderboard.di

import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        LearnersViewModel(get())
    }
}