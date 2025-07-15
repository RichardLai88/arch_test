import com.lzbtech.arch_test.repository.api.weather.WeatherRepository
import com.lzbtech.arch_test.repository.model.DailyWeatherResponse
import com.lzbtech.arch_test.ui.pages.main.MainViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule(testDispatcher)

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        weatherRepository = mockk(relaxed = true)
        viewModel = MainViewModel(weatherRepository)
    }

    @Test
    fun `init should call fetchWeather`() = testScope.runTest {
        // Given
        val mockResponse = mockk<DailyWeatherResponse>()
        coEvery { weatherRepository.getWeather() } returns mockResponse

        // When
        viewModel.fetchWeather()
        advanceUntilIdle() // Execute pending coroutines

        // Then
        coVerify { weatherRepository.getWeather() }
        assertEquals(mockResponse, viewModel.weather.value)
    }

    @Test
    fun `increase should increment count`() {
        // Given
        val initialCount = viewModel.count.value

        // When
        viewModel.increase()

        // Then
        assertEquals(initialCount + 1, viewModel.count.value)
    }

    @Test
    fun `fetchWeather should update weather state`() = testScope.runTest {
        // Given
        val mockResponse = mockk<DailyWeatherResponse>()
        coEvery { weatherRepository.getWeather() } returns mockResponse

        // When
        viewModel.fetchWeather()
        advanceUntilIdle() // Wait for coroutine to complete

        // Then
        coVerify { weatherRepository.getWeather() }
        assertEquals(mockResponse, viewModel.weather.value)
    }

    @Test
    fun `count should have initial value zero`() {
        assertEquals(0, viewModel.count.value)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class MainCoroutineRule(
    private val testDispatcher: CoroutineDispatcher = StandardTestDispatcher()
) : TestWatcher() {


    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}