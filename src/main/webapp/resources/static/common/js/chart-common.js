// syusyu.common.Chart namespace를 정의
namespace("syusyu.common.Chart");

syusyu.common.Chart = {
    /**
     * 차트를 생성하는 함수.
     *
     * @param {string} id - 차트가 그려질 캔버스 요소의 ID
     * @param {string} chartType - 생성할 차트의 종류 (예: 'line', 'bar')
     * @param {Array} dataLabels - 차트 라벨
     * @param {Array} dataValues - 차트에 보여줄 데이터
     * @param {string} [axisFormat='y'] - 숫자 형식을 적용할 축 ('x' 또는 'y') 기본값은 'y'
     *
     * @returns {Object} - 생성된 차트 객체
     * @author min
     * @since 2023/08/06
     */
    createChart(id, chartType, dataLabels, dataValues, axisFormat = 'y') {
        // 차트 데이터 준비
        const chartData = {
            labels: dataLabels,
            datasets: [{
                data: dataValues,
                borderColor: 'rgb(75, 192, 192)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
            }]
        };

        // 축 설정
        const scalesOptions = {
            y: {
                beginAtZero: true
            }
        };
        scalesOptions[axisFormat] = { // // 'axisFormat'으로 지정된 축에는 숫자 형식이 적용됨
            ticks: {
                callback: function (value, index, values) {
                    return value.toLocaleString();
                }
            }
        }

        // Chart 생성
        return new Chart(document.getElementById(id).getContext('2d'), {
            type: chartType,
            data: chartData,
            options: {
                indexAxis: axisFormat === 'x' ? 'y' : 'x',
                scales: scalesOptions,
                plugins: {
                    legend: {
                        display: false
                    },
                    tooltip: {
                        callbacks: {
                            beforeTitle: function () {
                                return '';
                            }
                        }
                    }
                }
            }
        });
    }

}